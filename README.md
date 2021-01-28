# rest-data-sample
Simple rest web service with spring boot. Library with books, authors, reviews, users and tags.
<ul>
  <li><a href="src/main/java/rest/data/sample/authors/">Authors controller</a> <b>"/library/authors"</b><ul>
                        <li><b>"/all"</b> (GET) - list of all author entities</li>
                        <li><b>"/name-contains={str}"</b> (GET) - list of author entities that have 'str' in name property</li>
                        <li><b>"/works"</b> (POST:Request with author id and name) - list of book entities that are linked with author</li>
                      </ul>
  </li>
  
  <li><a href="src/main/java/rest/data/sample/books/">Books controller</a> <b>"/library/books"</b><ul>
                        <li><b>"/all"</b> (GET) - list of all book entities</li>
                        <li><b>"/name-contains={str}"</b> (GET) - list of book entities in json that have 'str' in name property</li>
                        <li><b>"/released-between"</b> (GET) (RequestParam: from, to) - list of book entities with released date property between 'from' and 'to'</li>
                        <li><b>"/find"</b> (GET) (RequestParam: from, to, name) - list of book entities with released date property between 'from','to' and have 'str' in name property</li>
                      </ul>
  </li>
  
  <li><a href="src/main/java/rest/data/sample/tags/">Tags controller</a> <b>"/library/tags"</b> <ul>
                        <li><b>"/all"</b> (GET) - list of all tag entities</li>
                        <li><b>"/all-sort-name"</b> (GET) - list of all tag entities ordered by name property</li>
                        <li><b>"/books-by-tag"</b> (POST:List of requests with tags ids) - list of all book entities that linked with requested tags</li>
                        <li><b>"/authors-by-tag"</b> (POST:List of requests with tags ids) - list of all author entities that linked with requested tags in their books</li>
                        <li><b>"/books-by-tag-name/{bookName}"</b> (POST:List of requests with tags ids) - list of all book entities that linked with requested tags and have 'str' in name property</li>
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
