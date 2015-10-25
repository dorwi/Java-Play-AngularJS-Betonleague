function HomeCtrl(){
  	var self = this;
    self.json = {
                  "first": {
                              "name": "West",
                              "standings": [
      {
        "name": "Cartel de Medellin",
        "pos": 1,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Hiperventilacija",
        "pos": 2,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Sremcica",
        "pos": 3,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Alkohol Junajted",
        "pos": 4,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Fantazija stogod",
        "pos": 5,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Sestari",
        "pos": 6,
        "mp": 0,
        "gd": 0,
        "pts": 0
      }
    ],
                  "thisRound": {
                                  "name" : "1. Round",
                                  "matches": [
      {
        "home": "Sremcica",
        "away": "Sestari"
      },
      {
        "home": "Cartel de Medellin",
        "away": "Hiperventilacija"
      },
      {
        "home": "Fantazija stogod",
        "away": "Alkohol Junajted"
      }
      ]
    }
  },
                  "second": {
                                  "name": "East",
                                  "standings": [
      {
        "name": "Kufa",
        "pos": 1,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Crveni djavoli",
        "pos": 2,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Vozdovac",
        "pos": 3,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Legija stranaca",
        "pos": 4,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Anchorage",
        "pos": 5,
        "mp": 0,
        "gd": 0,
        "pts": 0
      },
      {
        "name": "Lekino United",
        "pos": 6,
        "mp": 0,
        "gd": 0,
        "pts": 0
      }
    ],
                              "thisRound": {
                                                "name" : "1. Round",
                                                "matches": [
      {
        "home": "Vozdovac",
        "away": "Anchorage"
      },
      {
        "home": "Kufa",
        "away": "Legija stranaca"
      },
      {
        "home": "Crveni djavoli",
        "away": "Lekino United"
      }
      ]
    }
  }
};}

frontendApp.controller('HomeCtrl',HomeCtrl);
