suite = {
    "name": "SatNQClause",
    "mxversion": "5.263.8",
    "groupId": "com.pthariensflame.satnq-clause",
    "version": "20.2.0",
    "release": False,
    "developer": {
        "name": "Alexander Ronald Altman",
        "email": "alexanderaltman@me.com",
    },
    "scm": {
        "url": "https://github.com/pthariensflame/SatNQClause",
        "read": "https://github.com/pthariensflame/SatNQClause.git",
        "write": "git@github.com:pthariensflame/SatNQClause.git",
    },
    "defaultLicense": "BSD-new",

    "imports": {
        "suites": [
        ]
    },

    "libraries": {
    },

    "projects": {
        "com.pthariensflame.satnq-clause": {
            "javaCompliance": "8",
        },
        "com.pthariensflame.satnq-clause.jdk9": {
            "javaCompliance": "9+",
            "multiReleaseJarVersion": "9",
            "overlayTarget": "com.pthariensflame.satnq-clause",
            "dependencies": [
                "com.pthariensflame.satnq-clause",
            ],
        },
    },
}
