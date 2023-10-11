<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Note</title>
    <style>
        /* CSS для кнопок форматирования */
        button {
            margin-right: 5px;
        }
    </style>
</head>
<body>
<h1>Create a New Note</h1>
<form action="/notes/create" method="post">
    <label for="noteText">Note Text:</label>
    <div contenteditable="true" id="noteText" name="text" style="border: 1px solid #ccc; padding: 5px;" rows="4" cols="50"></div>
    <br>
    <!-- Кнопки форматирования -->
    <button type="button" onclick="document.execCommand('italic', false, null);">Italic</button>
    <button type="button" onclick="document.execCommand('bold', false, null);">Bold</button>
    <button type="button" onclick="document.execCommand('underline', false, null);">Underline</button>
    <br>
    <!-- Выбор шрифта и размера текста -->
    <label for="font">Font:</label>
    <select id="font" name="font" onchange="changeFont()">
        <option value="Arial">Arial</option>
        <option value="Times New Roman">Times New Roman</option>
        <!-- Добавьте другие шрифты по вашему выбору -->
    </select>
    <label for="fontSize">Font Size:</label>
    <select id="fontSize" name="fontSize" onchange="changeFontSize()">
        <option value="12px">12px</option>
        <option value="14px">14px</option>
        <!-- Добавьте другие размеры по вашему выбору -->
    </select>
    <br>
    <button type="submit">Create</button>
</form>
<a href="/notes/">Back to List</a>

<script>
    // Функция для изменения шрифта
    function changeFont() {
        const fontSelect = document.getElementById("font");
        const selectedFont = fontSelect.options[fontSelect.selectedIndex].value;
        document.execCommand('fontName', false, selectedFont);
    }

    // Функция для изменения размера текста
    function changeFontSize() {
        const fontSizeSelect = document.getElementById("fontSize");
        const selectedFontSize = fontSizeSelect.options[fontSizeSelect.selectedIndex].value;
        document.execCommand('fontSize', false, selectedFontSize);
    }
</script>
</body>
</html>
