<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <title>Inici de Sessió</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-5">
    <h2>Inicia sessió</h2>

    <g:if test="${flash.message}">
        <div class="alert alert-danger">${flash.message}</div>
    </g:if>

    <g:form action="authenticate" method="POST">
        <div class="mb-3">
            <label for="username" class="form-label">Usuari</label>
            <input type="text" class="form-control" name="username" id="username" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Contrasenya</label>
            <input type="password" class="form-control" name="password" id="password" required>
        </div>
        <button type="submit" class="btn btn-primary">Entrar</button>
    </g:form>
</div>
</body>
</html>
