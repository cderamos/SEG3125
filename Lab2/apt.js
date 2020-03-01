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
    if(comName.value == "" && tSector.value == "" && aVector.value==""&& assocMalware.value=="" &&
    ttp.value==""&& modOps.value==""&&toolsets.value==""&& refs.value==""){
      alert("Please fill out all the mandatory fields.");
    } else {
      alert("Success. Apt TESTER has been added to the matrix.");
      //refresh form
    }
}
function tester(){
  alert("WORKS");
}

function updateAPTInfo(){
  
}
