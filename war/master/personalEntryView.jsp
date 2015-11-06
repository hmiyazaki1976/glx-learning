<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=MS932" />
<title>ユーザー登録</title>
</head>
<body>
<p>ユーザー登録</p>
<form method="post" action="PersonEntry">
<table>
	<tr>
		<td>ユーザーコード</td>
		<td><input type="text" ${f:text("userCode")} class="${f:errorClass("userCode","err")}"/>
			<span class="err">${errors.userCode}</span><br/></td>
	</tr>
	<tr>
		<td>ユーザー名</td>
		<td><input type="text" ${f:text("userName")} class="${f:errorClass("userName","err")}"/>
			<span class="err">${errors.userName}</span><br/></td>
	</tr>
	<tr>
		<td>連絡用メールアドレス</td>
		<td><input type="text" ${f:text("mailTo")} class="${f:errorClass("mailTo","err")}"/>
			<span class="err">${errors.mailTo}</span><br/></td>
	</tr>
	<tr>
		<td>所属部門</td>
		<td><select name="bumon">
			<option ${f:select("bumon", "B001")}>第一システム</option>
			<option ${f:select("bumon", "B002")}>第二システム</option>
			<option ${f:select("bumon", "B003")}>第三システム</option>
			<option ${f:select("bumon", "B004")}>第四システム</option>
			<option ${f:select("bumon", "B005")}>第五システム</option>
			</select></td>
	</tr>
	<tr>
		<td>所属チーム</td>
		<td><select name="team">
			<option ${f:select("team", "T001")}>１T</option>
			<option ${f:select("team", "T002")}>２T</option>
			<option ${f:select("team", "T003")}>３T</option>
			</select></td>
	</tr>
	<tr>
		<td>その他所属</td>
		<td><select name="other">
			<option ${f:select("other", "O001")}>役員会</option>
			<option ${f:select("other", "O002")}>風紀委員</option>
			<option ${f:select("other", "O003")}>図書委員</option>
			<option ${f:select("other", "O004")}>美化委員</option>
			</select></td>
	</tr>
</table>
<input type="submit" value="登録" class="button" />
<input type="reset" value="リセット " class="button" />
</form>
<p>登録状況</p>
<table>
<c:forEach var="person" items="${personList}" varStatus="ps" >
	<tr>
		<td>ユーザーコード</td><td>${f:h(person.userCode)}</td>
	</tr>
	<tr>
		<td>ユーザーID</td><td>${f:h(person.userId)}</td>
	</tr>
	<tr>
		<td>ユーザー名</td><td>${f:h(person.userName)}</td>
	</tr>
	<tr>
		<td>連絡用メールアドレス</td><td>${f:h(person.mailto)}</td>
	</tr>
	<tr>
		<td>所属部門</td><td>${f:h(person.bumon)}</td>
	</tr>
	<tr>
		<td>所属チーム</td><td>${f:h(person.team)}</td>
	</tr>
	<tr>
		<td>その他所属</td><td>${f:h(person.other)}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>
