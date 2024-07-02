@import exercise.dto.posts.PostsPage
@import exercise.util.NamedRoutes
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все посты</h1>

            <nav aria-label="Page navigation example">
                <ul class="pagination">
                    <li class="page-item"><a class="page-link"
                                             href="?page=${page.getPage() < 2 ? 1 : page.getPage() - 1}">Previous</a>
                    </li>
                    <li class="page-item"><a class="page-link"
                                             href="${NamedRoutes.postsPath()}?page=${page.getPage()}">${page.getPage()}</a>
                    </li>
                    <li class="page-item"><a class="page-link" href="?page=${page.getPage() + 1}">Next</a></li>
                </ul>
            </nav>

            <%--            <nav aria-label="Page navigation example">--%>
            <%--                <ul class="pagination">--%>
            <%--                    <li class="page-item">--%>
            <%--                        <a class="page-link" href="?page=${page.getPage() < 2 ? 1 : page.getPage() - 1}"--%>
            <%--                           aria-label="Previous">--%>
            <%--                            <span aria-hidden="true">&laquo;</span>--%>
            <%--                        </a>--%>
            <%--                    </li>--%>
            <%--                    <li class="page-item"><a class="page-link"--%>
            <%--                                             href="${NamedRoutes.postsPath()}?page=${page.getPage()}">${page.getPage()}</a>--%>
            <%--                    </li>--%>
            <%--                    <li class="page-item">--%>
            <%--                        <a class="page-link" href="?page=${page.getPage() + 1}" aria-label="Next">--%>
            <%--                            <span aria-hidden="true">&raquo;</span>--%>
            <%--                        </a>--%>
            <%--                    </li>--%>
            <%--                </ul>--%>
            <%--            </nav>--%>

            @for(var post : page.getPosts())
                <div>
                    <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
                </div>
            @endfor

        </main>
    </div>
`
)