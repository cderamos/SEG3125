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
    if(comName.value == "" || tSector.value == "" || aVector.value=="" || assocMalware.value=="" ||
    ttp.value=="" || modOps.value=="" || toolsets.value=="" || refs.value==""){
      alert("Please fill out all the mandatory fields.");
    } else {
      alert("Success. Apt TESTER has been added to the matrix.");
      //refresh form
    }
}

function submitSuccess(){
  if(document.getElementById("aname1").value == "" && document.getElementById('aid1').value == "" &&
     document.getElementById('atype1').value == "" && document.getElementById('aversion1').value == "") {
    alert("Nothing updated.");
  } else {
    alert("Success. APT info updated.")
    var d = new Date();
    document.getElementById('moddate').innerHTML= d.toUTCString();
    //update info
    var link = document.getElementById("aname1").value;
    if(link != ""){
      document.getElementById('attack1').textContent = link;
    }
    if(document.getElementById('aid1').value != ""){
      document.getElementById('id1').innerHTML = document.getElementById('aid1').value;
    }
    if(document.getElementById('atype1').value !=""){
      document.getElementById('type1').innerHTML = document.getElementById('atype1').value;
    }
    if(document.getElementById('aversion1').value !=""){
      document.getElementById('version1').innerHTML = document.getElementById('aversion1').value;
    }
  }
  document.getElementById("form1").reset();
}
