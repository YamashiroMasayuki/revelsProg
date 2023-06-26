function serchBtnClick(){
	document.userEditSerch.submit();
}
function updateBtnClick(){
	document.updateUserInfo.submit();
}


document.addEventListener('DOMContentLoaded', syoki);

function syoki(){
	const updateUserIDClass = document.getElementsByClassName('editInfoUserID_area')[0];
	const inputUpdateUserIDTag = updateUserIDClass.getElementsByTagName('input')[0];
	inputUpdateUserIDTag.disabled = true;
}