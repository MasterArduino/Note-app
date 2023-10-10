<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Delete Note</title>
</head>
<body>
<h1>Delete Note</h1>
<p>Are you sure you want to delete this note?</p>
<form action="/notes/delete/${note.id}" method="post">
    <button type="submit">Delete</button>
</form>
<a href="/notes/">Cancel</a>
</body>
</html>
