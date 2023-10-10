<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Note List</title>
</head>
<body>
<h1>Note List</h1>
<ul>
    <#list notes as note>
        <li>
            <span>${note.text}</span>
            <a href="/notes/edit/${note.id}">Edit</a>
            <form action="/notes/delete/${note.id}" method="post" style="display: inline;">
                <button type="submit">Delete</button>
            </form>
        </li>
    </#list>
</ul>
<a href="/notes/create">Create New Note</a>
</body>
</html>
