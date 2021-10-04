$(document).ready(function(){
 

    $("#firstNameError").hide();
    $("#lastNameError").hide();
    $("#emailError").hide();
    $("#addressError").hide();
    $("#mobileError").hide();
    $("#genderError").hide();
    $("#noteError").hide();
    
    var firstNameError=false;
    var lastNameError=false;
    var emailError=false;
    var addressError=false;
    var mobileError=false;
    var genderError=false;
    var noteError=false;

    function validate_firstName()
    {

        var val=$("#firstName").val();
        if(val=="")
        {
         $("#firstNameError").show();
         $("#firstNameError").html("*Please Enter First Name");
         $("#firstNameError").css("color","red");
        firstNameError=false; 
        }
        else
        {
            $("#firstNameError").hide();
            firstNameError=true;
        }
        return firstNameError;
    }

    function validate_lastName()
    {
        var val=$("#lastName").val();
        if(val=="")
        {
            $("#lastNameError").show();
            $("#lastNameError").html("*Please Enter Last Name");
            $("#lastNameError").css("color","red");
        lastNameError=false;
        }
        else{
            $("#lastNameError").hide();
            lastNameError=true;
        }
        return lastNameError;
    }
    function validate_email()
    {
        var val=$("#email").val();
        if(val=="")
        {
       $("#emailError").show();
       $("#emailError").html("*Please Enter Email Id");
       $("#emailError").css("color","red");
        emailError=false;
        }
        else
        {
            $("#emailError").hide();
            emailError=true;
        }
        return emailError;
    }
    function validate_address()
    {
        var val=$("#address").val();
        if(val=="")
        {
       $("#addressError").show();
       $("#addressError").html("*Please Enter Address");
       $("#addressError").css("color","red");
        addressError=false;
        }
        else{
            $("#addressError").hide();
            addressError=true;
        }
        return addressError;

    }
  function validate_mobile()
  {
       var val=$("#mobile").val();
       if(val=="")
       {
        $("#mobileError").show();
        $("#mobileError").html("*Please Enter Mobile Number");
        $("#mobileError").css("color","red");
      mobileError=false;
       }
       else
       {
        $("#mobileError").hide();
        mobileError=true;
       }
       return mobileError;
  }
  function validate_gender()
  {
      var len=$("input [type='radio'] [name='gender']:checked").length;
      if(len==0)
      {
      $("#genderError").show();
      $("#genderError").html("*Please Choose Gender");
      $("#genderError").css("color","red");
      genderError=false;
  }
  else
  {
    $("#genderError").hide();
    genderError=true;
  }
  return genderError;
  }
  function validate_note()
  {
   var val=$("#note").val();
   if(val=="")
   {
    $("#noteError").show();
    $("#noteError").html("*Please Enter Note");
    $("#noteError").css("color","red");
        noteError=false;
   }
else
{
    $("#noteError").hide();
    noteError=true;
}
return noteError;
  }

  $("#firstName").keyup(function(){
        validate_firstName();

  });
  $("#lastName").keyup(function(){
        validate_lastName();

  });
  $("#email").keyup(function(){
        validate_email();

  });

  $("#address").keyup(function(){
        validate_address();

  });
  $("#mobile").keyup(function(){
        validate_mobile();

  });
  $("input [type='radio'] [name='gender']").click(function(){
        validate_gender();

  });
  $("#note").keyup(function(){
        validate_note();

  });

  $("#docreg").submit(function(){

    validate_firstName();
    validate_lastName();
    validate_email();
    validate_address();
    validate_mobile();
    validate_gender();
    validate_note();
    if(firstNameError && lastNameError && emailError && addressError && mobileError && noteError)
    return true; else return false;

  });
});