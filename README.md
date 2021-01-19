# rest-data-sample
<ul>
  <li>Authors controller #"/library/authors"#<ul>
                        <li>#"/all"# (GET) - list of all author entities</li>
                        <li>#"/name-contains={str}"# (GET) - list of author entities that have 'str' in name property</li>
                        <li>#"/works"# (POST:Request with author id and name) - list of book entities that are linked with author</li>
                      </ul>
  </li>
  
  <li>Books controller #"/library/books"#<ul>
                        <li>#"/all"# (GET) - list of all book entities</li>
                        <li>#"/name-contains={str}"# (GET) - list of book entities in json that have 'str' in name property</li>
                        <li>#"/released-between"# (GET) (RequestParam: from, to) - list of book entities with released date property between 'from' and 'to'</li>
                        <li>#"/find"# (GET) (RequestParam: from, to, name) - list of book entities with released date property between 'from','to' and have 'str' in name property</li>
                      </ul>
  </li>
  
  <li>Tags controller #"/library/tags"# <ul>
                        <li>#"/all"# (GET) - list of all tag entities</li>
                        <li>#"/all-sort-name"# (GET) - list of all tag entities ordered by name property</li>
                        <li>#"/books-by-tag"# (POST:List of requests with tags ids) - list of all book entities that linked with requested tags</li>
                        <li>#"/authors-by-tag"# (POST:List of requests with tags ids) - list of all author entities that linked with requested tags in their books</li>
                        <li>#"/books-by-tag-name/{bookName}"# (POST:List of requests with tags ids) - list of all book entities that linked with requested tags and have 'str' in name property</li>
                      </ul>
  </li>
</ul>
