 $(document).ready(function () {
        $("#codeError").hide();
        $("#nameError").hide();
        $("#noteError").hide();
        var codeError = false;
        var nameError = false;
        var noteError = false;

        function validate_code() {
          var val = $("#code").val();
          var exp = /^[A-Z]{4,10}$/;
          if (val == "") {
            $("#codeError").show();
            $("#codeError").html("*Please Enter Code");
            $("#codeError").css("color", "red");
            codeError = false;
          } else if (!exp.test(val)) {
            $("#codeError").show();
            $("#codeError").html("*Please Enter  valid Code min 4 & Max 10 Digits");
            $("#codeError").css("color", "blue");
            codeError = false;
          }else{
	     var id=0;
	     if($("#id").val!=undefined)
	     {
	     codeError=true;
	     id=$("#id").val();
	     }
	
	     $.ajax({
		    
		    url:'codecheck',
		    data:{"code":val,"id":id},
		    success:function(redData){
			if(redData!='')
			{
				$("#codeError").show();
				$("#codeError").html(redData);
				$("#codeError").css('color','red');
				codeError=false;
			}
			else
			{
				$("#codeError").hide();
				codeError=true;
			}
			
			
		}
	});
} 
          
          return codeError;
        }
        function validate_name() {
          var val = $("#name").val();
          var exp = /^[A-Za-z]{4,12}$/;
          if (val == "") {
            $("#nameError").show();
            $("#nameError").html("*Please Enter Name");
            $("#nameError").css("color", "red");
            nameError = false;
          } else if (!exp.test(val)) {
            $("#nameError").show();
            $("#nameError").html("*Please Enter only <b>Small or Capital LETTERS min 4 & Max 8 Characters<b>");
            $("#nameError").css("color", "blue");
            nameError = false;
          }else{
	
	$.ajax({
		
		url:'namecheck',
		data:{"name":val},
		success:function(nameData){
			if(nameData!='')
			{
				$("#nameError").show();
				$("#nameError").html(nameData);
				$("#nameError").css('color','red');
				nameError=false;
				
			}
			
			else
			{
				$("#nameError").hide();
				nameError=true;
				
			}	
		}	
	});
}
          
          return nameError;
        }
        function validate_note() {
          var val = $("#note").val();
          var exp = /^[A-za-z\s\*\@]*$/;
          if (val == "") {
            $("#noteError").show();
            $("#noteError").html("*Please Add Note");
            $("#noteError").css("color", "red");
            noteError = false;
          } else if (!exp.test(val)) {
            $("#noteError").show();
            $("#noteError").html("*Please <b>MUST ADD<b> Note...!!!");
            $("#noteError").css("color", "blue");
            noteError = false;
          } else {
            $("#noteError").hide();
            noteError = true;
          }

          return noteError;
        }

        $("#code").keyup(function () {
          validate_code();
        });
        $("#name").keyup(function () {
          validate_name();
        });
        $("#note").keyup(function () {
          validate_note();
        });

        $("#specialform").submit(function () {
          validate_code();
          validate_name();
          validate_note();
          if (codeError && nameError && noteError) return true;
          else return false;
        });
      });