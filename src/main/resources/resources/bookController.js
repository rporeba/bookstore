/**
 * Created by rporeba on 29.08.2016.
 */

bookstore.controller('BookController', function ($scope, $uibModal, $log, $http, BookService) {

//	var self = this;
//	self.book={itemId:null,isbn:'',bookTitle:'', numberOfPage:''};
// 	self.books=[]
//
// 	self.getAllBooks = function(){
// 		BookService.getAllBooks()
//	      .then(
//	                   function(resposne) {
//	                  	 self.books = resposne;
//	                   },
//	                    function(errResponse){
//	                        console.error('Błąd podczas pobierania danych');
//	                    }
//	           );
//	};
//
//	self.getBookDetails = function  (id){
//	BookService.getBookDetails(id)
//        .then(
//                     function(resposne) {
//                    	 $scope.books = resposne;
//                     },
//                      function(errResponse){
//                          console.error('Błąd podczas pobierania danych');
//                      }
//
//             );
//	};
//
//
//	self.createBook = function(book){
//    	BookService.createBook(book)
//                .then(
//                		self.getAllBooks,
//                        function(errResponse){
//                             console.error('Błąd przy tworzeniu nowej książki');
//                        }
//            );
//    };
//


    var self = this;
    $scope.books;

    getAllBooks();
    function getAllBooks() {
        BookService.getAllBooks()
            .then(
                function (resposne) {
                    $scope.books = resposne;
                },
                function (errResponse) {
                    console.error('Błąd podczas pobierania danych');
                }
            );
    };

    $scope.createBook = function (book) {
        BookService.createBook(book)
            .then(
                self.getAllBooks,
                function (errResponse) {
                    console.error('Błąd przy tworzeniu nowej książki');
                }
            );
    };


});