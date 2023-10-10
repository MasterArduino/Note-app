<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Note</title>
</head>
<body>
<h1>Create a New Note</h1>
<form action="/notes/create" method="post">
    <label for="text">Note Text:</label>
    <textarea id="text" name="text" rows="4" cols="50" name="text"></textarea>
    <br>
    <!-- Кнопки форматирования -->
    <button type="button" onclick="document.execCommand('italic', false, null);">Italic</button>
    <button type="button" onclick="document.execCommand('bold', false, null);">Bold</button>
    <button type="button" onclick="document.execCommand('underline', false, null);">Underline</button>
    <!-- Конец кнопок форматирования -->
    <br>
    <button type="submit">Create</button>
</form>
<a href="/notes/">Back to List</a>
</body>
</html>


