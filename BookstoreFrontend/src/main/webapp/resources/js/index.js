
	function fn1(){
		const username = document.getElementById("username").value;
		const password = document.getElementById("password").value;
		
		if(username.length < 5 || username.length > 50){
			alert("Username must be of Minimum 5 characters and Maximum of 50");
			return;
		}
		if(password.length < 5 || password.length > 50){
			alert("Password must be of Minimum 5 characters and Maximum of 50");
			return;
		}
		document.getElementById("loginform").submit();
	}
	
