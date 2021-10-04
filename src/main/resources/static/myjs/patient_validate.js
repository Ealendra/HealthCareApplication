$(document).ready(function(){
$("#firstNameError").hide();
$("#lastNameError").hide();

var firstNameError=false;
var lastNameError=false;

function validate_firstName()
{
    var val=$("#firstName").val();
    var exp=/^[A-Z]{1,9}$/;
 if(val=="")
 {
     $("#firstNameError").show();
     $("#firstNameError").html("*Please Enter First Name");
     $("#firstNameError").css("color","red");
     firstNameError=false;
 }
 else if(!exp.test(val))
 {
     $("#firstNameError").show();
     $("#firstNameError").html("*Please must Enter Capital Letters Only <b>min 1 & Max 8</b>");
     $("#firstNameError").css("color","blue");
     firstNameError=false;
 }
 else{
 $.ajax({
           url:'fnchecked',
            data:{"firstName":val},
           success:function(Data){
                  if(Data!='')
                  {
                          $("#firstNameError").show();
                          $("#firstNameError").html(Data);
                          $("#firstNameError").css("color","red");
                           firstNameError=false;
                  }
                  else
                  {
                         $("#firstNameError").hide();
                         firstNameError=true;
                  }
           }
 });

 }

return firstNameError;
}
function validate_lastName()
{
    var val=$("#lastName").val();
    var exp=/^[A-Z]{0,9}$/;
    if(val=="")
    {
       $("#lastNameError").show();
       $("#lastNameError").html("*Please Enter Last Name");
       $("#lastNameError").css("color","red");
       lastNameError=false;
    }
    else if(!exp.test(val))
    {
        $("#lastNameError").show();
        $("#lastNameError").html("*Please Enter only capital Letters")
        $("#lastNameError").css("color","blue");
        lastNameError=false;

    }
    else{

        $.ajax({
      url:'lnchecked',
      data:{"lastName":val}, 
      success:function(lnData)
      {
                 if(lnData!='')
                 {
                     $("#lastNameError").show();
                     $("#lastNameError").html(lnData);
                     $("#lastNameError").css("color","red");
                     lastNameError=false;
                 }
                 else{

                    $("#lastNameError").hide();
                    lastNameError=true;

                 }
      }

        });
    }

return lastNameError;
}

      $("#firstName").keyup(function()
      {

        validate_firstName();
      });
     $("#lastName").keyup(function(){
       validate_lastName();
});

$("#reg").submit(function(){
    validate_firstName();
    validate_lastName();
    if(firstNameError && lastNameError) return true; else return false;
});
});