function checkBoxes() {
	var agree1 = document.getElementById("agree1");
	var agree2 = document.getElementById("agree2");
	var checkAll = document.getElementById("checkAll");
	
        agree1.checked = checkAll.checked;
        agree2.checked = checkAll.checked;
}

function validateForm() {
    var agree1 = document.getElementById("agree1").checked;
    var agree2 = document.getElementById("agree2").checked;

    if (!agree1 || !agree2) {
        alert("약관에 동의해야 가입할 수 있습니다.");
        return false;
    }

    // 여기에 추가적인 검증 로직이 있다면 추가하세요.
	window.location.href = "/join";
    return true;
}

  
    
     /* function checkBoxValidation() {
      var check1 = document.getElementById("check1");
      var check2 = document.getElementById("check2");
      var validationMessage = document.getElementById("validationMessage");

      // 모두 체크되었는지 확인
      if (checkAll.checked) {
        if (!check1.checked || !check2.checked) {
          validationMessage.textContent = '모두 체크해주세요.';
        } else {
          validationMessage.textContent = ''; // 모두 체크되어 있으면 메시지를 지웁니다.
        }
      } else {
        validationMessage.textContent = ''; // 'Check All'이 체크되지 않은 경우 메시지를 지웁니다.
      }
    }*/
    
    function Form() {
		
	}