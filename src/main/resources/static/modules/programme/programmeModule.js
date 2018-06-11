angular.module("notesApp.programme", ['checklist-model','notesApp.programme.controllers', 'notesApp.programme.services']);
angular.module("notesApp.programme").config(function ($stateProvider, $locationProvider) {
    $stateProvider.state("programmes", {
        url: '/programmes',
        controller: 'ProgrammeController',
        templateUrl: 'modules/programme/views/liste.html'
    });
});