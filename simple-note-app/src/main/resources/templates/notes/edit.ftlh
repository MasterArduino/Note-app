<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Note</title>
</head>
<body>
<h1>Edit Note</h1>
<form action="/notes/edit/${note.id}" method="post">
    <input type="hidden" name="id" value="${note.id}">
    <label for="text">Note Text:</label>
    <textarea id="text" name="text" rows="4" cols="50" name="text">${note.text}</textarea>
    <br>
    <button type="submit">Save</button>
</form>
<a href="/notes/">Back to List</a>
</body>
</html>
