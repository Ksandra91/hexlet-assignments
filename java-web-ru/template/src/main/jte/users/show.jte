@import exercise.dto.users.UserPage
@param UserPage page
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <title>${page.getUser().getId()}</title>
</head>
<body>
<div>
    <main>
        <h1>${page.getUser().getFirstName()}</h1>
        <p>${page.getUser().toString()}</p>
    </main>
</div>
</body>
</html>