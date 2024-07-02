@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <div>
                <a href="/posts/index"> Все посты </a>
            </div>
            <div class="mb-3">
                <a href="/posts/${page.getPost().getId()}"></a>
            </div>
            <h1> ${page.getPost().getId()}</h1>
            <h2> ${page.getPost().getName()}</h2>
            <p> ${page.getPost().getBody()}</p>
        </main>
    </div>
`
)