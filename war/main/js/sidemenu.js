/* サイドメニューのjs */
function perSchedule() {
	alert("perSchedule");	
}

function perAnalysis() {
	alert("perAnalysis");
}

function perDataChange() {
	alert("perDataChange");
	var contentLine = "";

	document.getElementById("hoge").innerHTML = "	<div class='content-wrapper' id='mainContent'>";
	document.getElementById("hoge").innerHTML +="<section class='content'>";
	document.getElementById("hoge").innerHTML +="<p>ユーザー登録</p>";
	document.getElementById("hoge").innerHTML +="<form method='post' action='PersonEntry'>";
	document.getElementById("hoge").innerHTML +="	<table>";
	document.getElementById("hoge").innerHTML +="		<tr> ";
	document.getElementById("hoge").innerHTML +="			<td>ユーザーコード</td>";
	document.getElementById("hoge").innerHTML +="			<td><input type='text' ${f:text('userCode')} class='${f:errorClass('userCode','err')}'/> ";
	document.getElementById("hoge").innerHTML +="			<span class='err'>${errors.userCode}</span><br/></td> ";
	document.getElementById("hoge").innerHTML +="		</tr>";
	document.getElementById("hoge").innerHTML +="		<tr>";
	document.getElementById("hoge").innerHTML +="			<td>ユーザー名</td>";
	document.getElementById("hoge").innerHTML +="			<td><input type='text' ${f:text('userName')} class='${f:errorClass('userName','err')}'/>";
	document.getElementById("hoge").innerHTML +="			<span class='err'>${errors.userName}</span><br/></td>";
	document.getElementById("hoge").innerHTML +="		</tr>";
	document.getElementById("hoge").innerHTML +="		<tr>";
	document.getElementById("hoge").innerHTML +="			<td>連絡用メールアドレス</td>";"
	document.getElementById("hoge").innerHTML +="			<td><input type='text' ${f:text('mailTo')} class='${f:errorClass('mailTo','err')}'/>";
	document.getElementById("hoge").innerHTML +="			<span class='err'>${errors.mailTo}</span><br/></td>";
	document.getElementById("hoge").innerHTML +="		</tr>";
	document.getElementById("hoge").innerHTML +="		<tr>";
	document.getElementById("hoge").innerHTML +="			<td>所属部門</td>";
	document.getElementById("hoge").innerHTML +="			<td><select name='bumon'>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('bumon', 'B001')}>第一システム</option>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('bumon', 'B002')}>第二システム</option>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('bumon', 'B003')}>第三システム</option>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('bumon', 'B004')}>第四システム</option>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('bumon', 'B005')}>第五システム</option>";
	document.getElementById("hoge").innerHTML +="			</select></td>";
	document.getElementById("hoge").innerHTML +="		</tr>";
	document.getElementById("hoge").innerHTML +="		<tr>";
	document.getElementById("hoge").innerHTML +="			<td>所属チーム</td>";
	document.getElementById("hoge").innerHTML +="			<td><select name='team'>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('team', 'T001')}>１T</option>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('team', 'T002')}>２T</option>";
	document.getElementById("hoge").innerHTML +="				<option ${f:select('team', 'T003')}>３T</option>";
	document.getElementById("hoge").innerHTML +="			</select></td>";
	document.getElementById("hoge").innerHTML +="		</tr>";
	
	document.getElementById("hoge").innerHTML +="		<input type='submit' value='登録' class='button' />";
	document.getElementById("hoge").innerHTML +="		<input type='reset' value='リセット ' class='button' />";
	document.getElementById("hoge").innerHTML +="	</form>";        
	document.getElementById("hoge").innerHTML +="	</section>";
	document.getElementById("hoge").innerHTML +="</div>";
	
	document.getElementById("hoge").innerHTML = contentLine;

	
}

