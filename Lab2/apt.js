function checkEmptyFields() {
    var comName = document.getElementById("name");
    var altName= document.getElementById("alternate");
    var tSector= document.getElementById("tsector");
    var aVector= document.getElementById("attack");
    var assocMalware= document.getElementById("malware");
    var ttp= document.getElementById("ttp");
    var modOps= document.getElementById("modops");
    var toolsets= document.getElementById("toolsets");
    var refs= document.getElementById("refs");
    if(comName.value == "" && altName.value == "" && tSector.value == "" && aVector.value==""&& assocMalware.value=="" &&
    ttp.value==""&& modOps.value==""&&toolsets.value==""&& refs.value==""){
      alert("Please fill out all the fields.");
      return false;
    }
}
function tester(){
  alert("WORKS");
}

function loadLists(){
    //Create json list to fill table
    var apts = [
      {"APT ID": "attack-pattern--dcaa092b-7de9-4a21-977f-7fcb77e89c48",
      "APT NAME": "Access Token Manipulation",
      "DATE CREATED": "2017-12-14T16:46:06.044Z",
      "X-MITRE VERSION": "1.0",
      "TYPE": "attack-pattern",
      "LAST MODIFIED":"2018-02-14T16:46:06.044Z",},
      {
        "APT ID": "attack-pattern--dcaa092b-7de9-4a21-977f-7fcb77e89c48",
        "APT NAME": "Access Token Manipulation",
        "DATE CREATED": "2017-12-14T16:46:06.044Z",
        "X-MITRE VERSION": "1.0",
        "TYPE": "attack-pattern",
        "LAST MODIFIED":"2018-02-14T16:46:06.044Z",
      },
      {"APT ID": "attack-pattern--dcaa092b-7de9-4a21-977f-7fcb77e89c48",
      "APT NAME": "Access Token Manipulation",
      "DATE CREATED": "2017-12-14T16:46:06.044Z",
      "X-MITRE VERSION": "1.0",
      "TYPE": "attack-pattern",
      "LAST MODIFIED":"2018-02-14T16:46:06.044Z",},
      {
        "APT ID": "attack-pattern--dcaa092b-7de9-4a21-977f-7fcb77e89c48",
        "APT NAME": "Access Token Manipulation",
        "DATE CREATED": "2017-12-14T16:46:06.044Z",
        "X-MITRE VERSION": "1.0",
        "TYPE": "attack-pattern",
        "LAST MODIFIED":"2018-02-14T16:46:06.044Z",
      }
    ]

        // EXTRACT VALUE FOR HTML HEADER.
        // ('Book ID', 'Book Name', 'Category' and 'Price')
        var col = [];
        for (var i = 0; i < apts.length; i++) {
            for (var key in apts[i]) {
                if (col.indexOf(key) === -1) {
                    col.push(key);

                }
            }
        }
        // CREATE DYNAMIC TABLE.
        var table = document.createElement("table");
        // CREATE HTML TABLE HEADER ROW USING THE EXTRACTED HEADERS ABOVE.
        var tr = table.insertRow(-1);                   // TABLE ROW.
        for (var i = 0; i < col.length; i++) {
            var th = document.createElement("th");      // TABLE HEADER.
            th.setAttribute('class','head');
            th.innerHTML = col[i];
            tr.appendChild(th);
        }
        // ADD JSON DATA TO THE TABLE AS ROWS.
        for (var i = 0; i < apts.length; i++) {
            tr = table.insertRow(-1);
            for (var j = 0; j < col.length; j++) {
                var tabCell = tr.insertCell(-1);
                tabCell.innerHTML =apts[i][col[j]];
            }
        }
        // FINALLY ADD THE NEWLY CREATED TABLE WITH JSON DATA TO A CONTAINER.
        var divContainer = document.getElementById("show");
        divContainer.innerHTML = "";
        divContainer.appendChild(table);
    }
