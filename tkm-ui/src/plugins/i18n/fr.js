import AccountPage from "../../components/admin/AccountPage.vue";

const frMessages = {

    homePage: {
        title: "La Guyane Française, un pays au mille visages !",
        intro: "Tout Koulèr Mélanjé",
        description1: "est une application qui fait référence à la diversité du territoire guyanais. Un pays pluriculturel où se mélange différentes communautés telles que des Amérindiens, des Hmongs, des Brésiliens, des Guyanais, des Businengés... ",
        description2:"Ce pays méconnu et ayant parfois une mauvaise réputation se révèle comme une terre accueillante et offrant une expérience exceptionnelle et mémorable. ",
        description3: "Que vous soyez seul(e), en famille ou entre ami(e)s,",
        description4: "a pour objectif de vous faire découvrir ou redécouvrir la richesse de la Guyane Française à travers différentes activités ou encore par la gastronomie guyanaise. ",
        description5: "Ajoutez dans votre carnet de voyage les activités souhaitées et vivez une expérience inoubliable.",
        link: "Bon séjour !"    
    },

    activities: {
        title: "Activités de la Guyane Française",
        filter: "Filtrer",
        reservation: "Réservation",
        info: "Plus d'info",
    },

    mapPage: {
        title: "Localisation des activités",
        back: "Retour à la liste"
    },

    aboutPage: {
        title: "Carnet de voyage",
        description: "A 8h30 de vol de Paris et 2h des Antilles, la Guyane est une région française d’Amérique du Sud bordée par l’Océan Atlantique, située entre le Brésil et le Suriname. Terre française d’Amazonie, elle réunit à elle seule des richesses naturelles exceptionnelles, une biodiversité encore préservée, un foisonnement de cultures séculaires, des sites naturels uniques au monde, et la principale porte de l’Europe vers l’espace.",
        image1: "Iguane vert",
        formality: "formalité",
        flight: "Liaision aérienne : Air France et Air Caraïbes",
        entry: "Formalités d'entrée : carte d'identité ou passeport en cours de validité pour ressortissant français.e",
        health: "Santé : fièvre jaune obligatoire",
        lang: "Langue officielle : français",
        currency: "Monnaie : euro",
        hour: "Décalage horaire : -5h en été et -4h en hiver par rapport à la France métropolitaine",
        weather: "Climat : équatorial chaud tempéré par les alizés, et demeure à l'abri des cyclones (et des séismes)",
        description2: "Il est facile de se déplacer en Guyane. Toutefois, les transports en commun ne sont pas établis de manière homogène sur le territoire. Préférez une location de voiture ou des solutions de covoiturage.",
        description3: "Concernant le shopping, de manière générale, les magasins de Guyane sont ouverts du lundi au samedi, de 9h à 12h30 et de 16h à 19h. Les épiceries et supermarchés peuvent rester ouverts plus tard en soirée jusqu'à 21h30, ainsi que le dimanche matin de 9h à 12h30.",
        image2: "Orchidée",
        description4: "Laissez-vous surprendre par la richesse du patrimoine guyanais et par sa diversité culturelle. Avec plus d’une dizaine d’ethnies représentées, la Guyane est un bouillonnement culturel unique en son genre, façonné par des siècles d’histoire et de rencontres de civilisations !",
    },
    accountPage: {
        title: "Les comptes utilisateurs",
        firstName: "Prénom",
        lastName: "Nom",
        email: "Email",
        role: "Rôle",
        delete: "Supprimer"

    },

    formAuth: {
        create: "S'enregistrer",
        firstName: "Prénom",
        name: "Nom",
        email: "Email",
        password: "Mot de passe",
    },

    formLogin: {
        connect: "Se connecter",
        email: "Email",
        error: "Le champ est obligatoire",
        password: "Mot de passe",
        linkAuth: "Si vous n’avez pas de compte, cliquez sur le lien"
    },

    admin: {
        form: {
            title: {
                new: "Nouvelle activité",
                update: "Mettre à jour une activité",
            },
            name: "Nom de l'activité",
            description: "Description",
            image: "Image",
            location: 'Lieu',
            linkUrl: "Lien",
            send: "Envoyer",
            save: "Sauvegarder",
            back: "Retour sur la liste des activités"
        },
        edit: {
            title: "Dashboard des activités",
            buttonCreate: "Créer une nouvelle activité",
            image: "Image",
            name: "Nom",
            date: "Date",
            update: "Maj",
            delete: "Supprimer"
        }
    },

    profil: {
        title: "Mon carnet de favoris",
        link: "Je réserve"

    },

    common: {
        toast: {
            title: "Tout Koulèr Mélanjé"
        },
        status: {
            success: "L'activité a été créée avec succès.",
            done: "Cette activité a été ajoutée dans votre carnet de favoris",
            failure: "Une erreur s'est produite.",
            delete: "L'activité a bien été supprimée.",
            update: "L'activité a bien été mis à jour.",
            favory: "Cetta activité est déjà dans votre carnet de favoris."
        },
        error:"Le champ est obligatoire.",
        error1: "Le mot de passe doit être entre 8 - 42 caractères avec au moins une majuscule, au moins un chiffre et un caractère spécial @%*!",
        error2: "La taille de l'image doit être inférieur à 500ko.",
        error3: "Le nom de l'activité ne doit pas dépasser 250 caractères."
    },

    shared: {
        footer: {
            copy: "Tout Koulèr Mélanjé 2024 - Tous droits réservés.",
            politics: "Politique de confidentialité",
            mention: "Mentions Légales",
            mapSite: "Plan du site"
        },
        navbar: {
            homePage: "Accueil",
            activities: "Activités",
            map: "Carte",
            formality: "Formalités",
            favory: "Mon carnet"
        },
        navbarAdmin: {
            title: "Tout Koulèr Mélanjé - Dashboard",
            intro: "Gestion des activités",
            intro2: "Gestion des comptes utilisateurs",
            dashboard: "Dashboard",
            users: "Comptes utilisateurs",
            welcome: "Bienvenue",
            disconnect: "Se déconnecter"
        }
    }
}

export default frMessages;