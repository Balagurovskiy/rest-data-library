# rest-data-sample
Simple rest web service with spring boot. Library with books, authors, reviews, users and tags.
<ul>
  <li><a href="src/main/java/rest/data/sample/authors/">Authors controller</a> <b>"/library/authors"</b><ul>
                        <li><b>"/all"</b> (GET) - list of all author entities</li>
                        <li><b>"/name-contains={str}"</b> (GET) - list of author entities that have 'str' in name property</li>
                        <li><b>"/works"</b> (POST:Request with author id and name) - list of book entities that are linked with author</li>
                      </ul>
  </li>
   
</ul>
# entity relationship model
<img src="diag.png" width="800" height="500"/>
# tests
 <ul>
      <li><a href="src/test/java/rest/data/sample/AuthorsControllerTests.java">Authors controller test</a></li>
      <li><a href="src/test/java/rest/data/sample/BooksControllerTests.java">Books controller test</a></li>
</ul>
