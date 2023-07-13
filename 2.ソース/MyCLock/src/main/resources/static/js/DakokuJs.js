//ページ読み込み時使用不可ボタンの色を変化する。
//0を返却は出勤ボタンを使用可能に
function changeBtnColor(){
	let statusFlg = document.getElementsByClassName('kinmu_status')[0];
	let syukkinBtn = document.getElementsByClassName('syukkin_btn')[0];
	let taikinBtn = document.getElementsByClassName('taikin_btn')[0];
	if(statusFlg.innerText == "退勤中"){
		taikinBtn.classList.add('enable_btn');
		syukkinBtn.classList.remove('enable_btn');
		return 0;
	}
	else{
		syukkinBtn.classList.add('enable_btn');
		taikinBtn.classList.remove('enable_btn');
		return 1;
	}
}
//出退勤ボタン押下時、共通値保持
function syuttaikinSetData(){
	let systemViewDate = document.getElementsByClassName('systemViewDate')[0];
	let systemViewTime = document.getElementsByClassName('systemViewTime')[0];
	systemViewDate.value = document.getElementById("systemDate").innerHTML;
	systemViewTime.value = document.getElementById("systemTime").innerHTML;
}

//出勤時表示処理
function syukkinBtnClick(){
	syuttaikinSetData();
	let dakokuFlg = document.getElementsByClassName('dakokuFlg')[0];
	dakokuFlg.value = true;
	document.dakokuUpdate.submit();
}
//退勤時表示処理
function taikinBtnClick(){
	syuttaikinSetData();
	let dakokuFlg = document.getElementsByClassName('dakokuFlg')[0];
	dakokuFlg.value = false;
	document.dakokuUpdate.submit();
}

document.addEventListener('DOMContentLoaded', function() {
	
	//enableのボタンに関してはclickイベントを追加しない。
	if(changeBtnColor() == 0){
		let syukkinBtn = document.getElementsByClassName('syukkin_btn')[0];
		syukkinBtn.addEventListener('click', syukkinBtnClick);
	}
	else{
		let taikinBtn = document.getElementsByClassName('taikin_btn')[0];
		taikinBtn.addEventListener('click', taikinBtnClick);
	}
});

//時刻リアルタイム表示
function set2fig(num) {
   // 桁数が1桁だったら先頭に0を加えて2桁に調整する
   var ret;
   if( num < 10 ) { ret = "0" + num; }
   else { ret = num; }
   return ret;
}
function showClock(){
	var nowTime = new Date(); //  現在日時を得る
   	var nowHour = set2fig( nowTime.getHours() );
   	var nowMin  = set2fig( nowTime.getMinutes() );
   	var nowSec  = set2fig( nowTime.getSeconds() );
	var timeMsg = nowHour + ":" + nowMin + ":" + nowSec;
	document.getElementById("systemTime").innerHTML = timeMsg;
	
	var nowYYYY  = set2fig( nowTime.getFullYear() );
	var nowMM  = set2fig( nowTime.getMonth() + 1 );
	var nowDD  = set2fig( nowTime.getDate() );
	var dateMsg = nowYYYY + "年" + nowMM + "月" + nowDD + "日";
	document.getElementById("systemDate").innerHTML = dateMsg;
	
}
setInterval('showClock()',1000);


