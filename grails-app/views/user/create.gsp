<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuari</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>

<div class="container">
    <h2 class="my-4">Crear Nou Usuari</h2>

    <g:form action="save" method="POST">
        <div class="form-group">
            <label for="username">Nom d'usuari</label>
            <input type="text" class="form-control" id="username" name="username" required />
        </div>

        <div class="form-group">
            <label for="password">Contrasenya</label>
            <input type="password" class="form-control" id="password" name="password" required />
        </div>

        <button type="submit" class="btn btn-success my-3">Crear Usuari</button>
    </g:form>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

</body>
</html>
