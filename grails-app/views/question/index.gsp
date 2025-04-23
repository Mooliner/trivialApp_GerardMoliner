<!DOCTYPE html>
<html lang="ca">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Preguntes Trivial</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css">
    <style>
    body {
        background-color: #f4f4f9;
        font-family: 'Arial', sans-serif;
        padding: 20px;
    }
    .container {
        max-width: 800px;
        margin: 0 auto;
    }
    .header {
        text-align: center;
        margin-bottom: 30px;
    }
    .card {
        margin-top: 20px;
        box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
    }
    .question-table th, .question-table td {
        text-align: left;
        padding: 15px;
    }
    .question-table th {
        background-color: #007BFF;
        color: white;
    }
    .question-table tr:nth-child(even) {
        background-color: #f8f9fa;
    }
    .question-table tr:hover {
        background-color: #e2e6ea;
    }
    .btn-custom {
        background-color: #28a745;
        color: white;
    }
    .btn-custom:hover {
        background-color: #218838;
    }
    .btn-link-custom {
        color: #007bff;
    }
    .btn-link-custom:hover {
        color: #0056b3;
    }
    </style>
</head>
<body>

<div class="container">
    <div class="header">
        <h2 class="display-4">Preguntes Trivial</h2>
        <a href="${createLink(uri: '/login')}" class="btn btn-danger">Tancar Sessió</a>
        <p>Genera preguntes noves i desa-les al sistema.</p>
    </div>

    <div class="form-container">
        <!-- Botó per generar 5 preguntes noves -->
        <a href="${createLink(controller: 'question', action: 'generate')}" class="btn btn-custom">Generar 5 preguntes noves</a>

        <g:if test="${isAdmin}">
            <a href="${createLink(controller: 'user', action: 'create')}" class="btn btn-primary ms-2">Crear Nou Usuari</a>
        </g:if>

    </div>

    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Llistat de Preguntes Desades</h4>
            <table class="table table-striped question-table">
                <thead>
                <tr>
                    <th>Categoria</th>
                    <th>Pregunta</th>
                    <th>Resposta</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${questions}" var="q">
                    <tr>
                        <td>${q.category}</td>
                        <td>${q.question}</td>
                        <td>${q.answer}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>

    <div class="card">
        <div class="card-body">
            <h4 class="card-title">Llistat de Preguntes Generades</h4>
            <table class="table table-striped question-table">
                <thead>
                <tr>
                    <th>Categoria</th>
                    <th>Pregunta</th>
                    <th>Resposta</th>
                    <th>Acció</th>
                </tr>
                </thead>
                <tbody>
                <g:each in="${newQuestions}" var="q">
                    <tr>
                        <td>${q.category}</td>
                        <td>${q.question}</td>
                        <td>${q.answer}</td>
                        <td>
                        <!-- Botó per desar la pregunta -->
                            <g:form action="save" method="POST">
                                <input type="hidden" name="category" value="${q.category}" />
                                <input type="hidden" name="question" value="${q.question}" />
                                <input type="hidden" name="answer" value="${q.answer}" />
                                <button type="submit" class="btn btn-success btn-sm">Desar</button>
                            </g:form>
                        </td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.6/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.min.js"></script>

</body>
</html>
