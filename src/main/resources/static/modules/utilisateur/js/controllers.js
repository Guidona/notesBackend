angular.module("notesApp.utilisateurs.controllers", []).controller("UtilisateurController", ["$scope", "$modal", "$log", "Utilisateur", "Departement",
    function ($scope, $modal, $log, Utilisateur, Departement) {
        var uts = Utilisateur.query(function () {
            $scope.utilisateurs = uts;
        });

        var deps = Departement.query(function () {
            $scope.departements = deps;
        });
        $log.log(deps);
        $scope.editer = function (item, cle) {
            $scope.afficherFenetre(item, cle);
        };

        $scope.supprimer = function (item, cle) {
            if (confirm("Voulez vous vraiment supprimer cet utilisateur?")) {
                Utilisateur.remove({id: item.id}, function () {
                    $scope.utilisateurs.splice(cle, 1);
                });
            }
        };

        $scope.afficherFenetre = function (utilisateur,cle) {
            var modelInstance = $modal.open({
                templateUrl: 'modules/utilisateur/views/nouveau.html',
                controller: 'UtilisateurFenetreController',
                controllerAs: 'utilisateur',
                keyboard: true,
                backdrop: false,
                resolve: {
                    element: function () {
                        var tt = {};
                        tt.departements = $scope.departements;
                        tt.utilisateur = utilisateur;
                        tt.cle = cle;
                        return tt;
                    }
                }
            });
            modelInstance.result.then(function (resultat) {
                var item = resultat.item;
                var cle = resultat.cle;
                if (item.id === undefined) {
                    var toto = Utilisateur.save(item, function () {
                        $scope.utilisateurs.push(toto);
                    });
                } else {
                    item.$update(function (data) {
                        $scope.utilisateurs.splice(cle, 1, data);
                    });
                }
            }, function () {

            });
        };
    }]).controller("UtilisateurFenetreController", ["$log","$scope", "$modalInstance", "element", function ($log, $scope, $modalInstance, element) {
        $scope.element = element.utilisateur;
        $scope.cle = element.cle;
        $scope.departements = element.departements;
        $scope.tags = $scope.element.departements;
        $scope.element.departements = element.departements;
    
        $scope.loadItems = function (query) {
            return _.filter($scope.departements, function (de) {
                return de.code.toLowerCase().indexOf(query.toLowerCase()) > -1;
            });
        };

        $scope.valider = function () {
            var resultat = {};
            $scope.element.departements = $scope.tags;
            resultat.item = $scope.element;
            resultat.cle = $scope.cle;
            $modalInstance.close(resultat);
        };
        
        $scope.cancel = function () {
            $modalInstance.dismiss("Cancel");
        };
    }]);




