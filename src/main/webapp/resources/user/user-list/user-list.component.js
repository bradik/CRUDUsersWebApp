angular.module('userList').component('userList', {
    templateUrl: 'resources/user/user-list/user-list.template.html',
    controller: ['$location', 'UserService', UserListController]
});

function UserListController($location, UserService) {

    var self = this;

    self.users = UserService.query();

    self.create = function () {
        $location.path('/create');
    };

    self.edit = function (id) {
        $location.path('/edit/' + id);
    };

    self.currentPage = 0;
    self.itemsPerPage = 4;

    self.countItems = function () {
        return self.filtered.length;
    };

    self.firstPage = function() {
        return self.currentPage == 0;
    };

    self.lastPage = function() {
        var lastPageNum = Math.ceil(self.countItems() / self.itemsPerPage - 1);
        return self.currentPage == lastPageNum;
    };
    self.numberOfPages = function(){
        return Math.ceil(self.countItems() / self.itemsPerPage);
    };
    self.startingItem = function() {
        return self.currentPage * self.itemsPerPage;
    };
    self.pageBack = function() {
        self.currentPage = self.currentPage - 1;
    };
    self.pageForward = function() {
        self.currentPage = self.currentPage + 1;
    };

    self.usersFilter = function () {

        return true;
    }
}

angular.module('userList').filter('startFrom', function(){
    return function(input, start){
        start = +start;
        return input.slice(start);
    }
})