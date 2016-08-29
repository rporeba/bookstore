/**
 * Created by rporeba on 29.08.2016.
 */

bookstore.factory('BookService', ['$http', '$q', function ($http, $q) {

    return {

        getAllBooks: function () {

            return $http.get('http://localhost:8081/bookstore/search')
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error when loading books');
                        return $q.reject(errResponse);
                    }
                );
        },

        searchBooks: function (book) {
            return $http.post('http://localhost:8081/bookstore/search', book)
                .then(
                    function (response) {
                        return response.data;
                    },
                    function (errResponse) {
                        console.error('Error when searching books');
                        return $q.reject(errResponse);
                    }
                );
        }

    };

}]);