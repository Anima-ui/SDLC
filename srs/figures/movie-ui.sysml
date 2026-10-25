package MovieGuideUI {
    private import ScalarValues::*;

    // The model describes the UI structure; visual styling is documented
    // separately in the PNG screen mockups.
    part def Application {
        part navigation : Navigation;
        part catalog : CatalogScreen;
        part collection : CollectionScreen;
        part recommendations : RecommendationsScreen;
        part movieDetails : MovieDetailsScreen;
    }

    part def Navigation {
        attribute activeSection : String;
        attribute signedIn : Boolean;
    }

    part def CatalogScreen {
        part search : SearchPanel;
        part results : MovieCard[0..*];
        attribute emptyResultMessage : String;
    }

    part def SearchPanel {
        attribute titleQuery : String;
        attribute genreFilter : String;
        attribute yearFilter : Integer;
    }

    part def MovieCard {
        attribute title : String;
        attribute releaseYear : Integer;
        attribute genres : String;
    }

    part def MovieDetailsScreen {
        part movie : MovieCard;
        attribute personalStatus : String;
        attribute watchedDate : String;
        attribute rating : Integer;
        attribute note : String;
    }

    part def CollectionScreen {
        part entries : CollectionEntry[0..*];
        attribute statusFilter : String;
        attribute sortOrder : String;
    }

    part def CollectionEntry {
        part movie : MovieCard;
        attribute status : String;
        attribute watchedDate : String;
        attribute rating : Integer;
    }

    part def RecommendationsScreen {
        part suggestions : RecommendationCard[0..10];
        attribute emptyProfileMessage : String;
    }

    part def RecommendationCard {
        part movie : MovieCard;
        attribute reason : String;
    }

    action def SearchMovies {
        in query : String;
        out resultCount : Integer;
    }

    action def MarkWatched {
        in movieTitle : String;
        in rating : Integer;
    }

    action def AddToWatchlist {
        in movieTitle : String;
    }

    part application : Application;

    view 'Screen structure' {
        expose application::**;
        render Views::asTreeDiagram;
    }
}
