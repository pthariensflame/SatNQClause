suite = {
    "name": "SatNQClause",
    "mxversion": "5.263.8",
    "versionConflictResolution": "latest",

    "groupId": "com.pthariensflame.satnq-clause",
    "version": "0.0.1",
    "release": False,

    "defaultLicense": "BSD-new",
    "developer": {
        "name": "Alexander Ronald Altman",
        "email": "alexanderaltman@me.com",
    },
    "scm": {
        "url": "https://github.com/pthariensflame/SatNQClause",
        "read": "https://github.com/pthariensflame/SatNQClause.git",
        "write": "git@github.com:pthariensflame/SatNQClause.git",
    },

    "imports": {
        "suites": [
            {
                "name": "truffle",
                "version": "3af0bff031fd7b9771fb74a323928b70576a8254",
                "subdir": True,
                "urls": [
                    {
                        "url": "https://github.com/oracle/graal",
                        "kind": "git",
                    },
                ],
            },
            # {
            #     "name": "tools",
            #     "version": "3af0bff031fd7b9771fb74a323928b70576a8254",
            #     "subdir": True,
            #     "urls": [
            #         {
            #             "url": "https://github.com/oracle/graal",
            #             "kind": "git",
            #         },
            #     ],
            # },
            # {
            #     "name": "regex",
            #     "version": "3af0bff031fd7b9771fb74a323928b70576a8254",
            #     "subdir": True,
            #     "urls": [
            #         {
            #             "url": "https://github.com/oracle/graal",
            #             "kind": "git",
            #         },
            #     ],
            # },
        ],
    },

    "libraries": {
        "SATNQ_JLINE_READER": {
            "sha1": "3ae8dbc62a23fd8ffbb2e389c6d5df2b50efa699",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-reader",
                "version": "3.14.1",
            }
        },
        "SATNQ_JLINE_STYLE": {
            "sha1": "c20b8b8593c0f120f1a7a9916bf6cacf455f0c06",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-style",
                "version": "3.14.1",
            }
        },
        "SATNQ_JLINE_TERMINAL": {
            "sha1": "6eaf4f5a16d6250bc81b4fc046227e23e85d3783",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-terminal",
                "version": "3.14.1",
            }
        },
        "SATNQ_JLINE_TERMINAL_JANSI": {
            "sha1": "ad8f8a52ea0be842cbe75d0a184ba6c9b2a02900",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-terminal-jansi",
                "version": "3.14.1",
            }
        },

        "SATNQ_JANSI": {
            "sha1": "ad8f8a52ea0be842cbe75d0a184ba6c9b2a02900",
            "maven": {
                "groupId": "org.fusesource.jansi",
                "artifactId": "jansi",
                "version": "1.18",
            }
        },

        "SATNQ_ANTLR4_RUNTIME": {
            "sha1": "2d0456a791f3a95916c8c23b3bea3a90eea24720",
            "maven": {
                "groupId": "org.antlr",
                "artifactId": "antlr4-runtime",
                "version": "4.8-1",
            }
        },
        "SATNQ_ANTLR4_COMPLETE": {
            "sha1": "ca08d2a2b7ffe0709638a951d767b8d93d46023f",
            "maven": {
                "groupId": "org.antlr",
                "artifactId": "antlr4",
                "version": "4.8-1",
                "classifier": "complete",
            }
        },
    },

    "projects": {
        "com.pthariensflame.satnq-clause.shell": {
            "javaCompliance": "8",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "dependencies": [
                "SATNQ_JLINE_READER",
                "SATNQ_JLINE_STYLE",
                "SATNQ_JLINE_TERMINAL",
                "SATNQ_JLINE_TERMINAL_JANSI",
                "SATNQ_JANSI",
                "sdk:LAUNCHER_COMMON",
                "com.pthariensflame.satnq-clause.parser",
                "com.pthariensflame.satnq-clause.lang",
            ],
        },
        "com.pthariensflame.satnq-clause.shell.jdk9": {
            "javaCompliance": "9+",
            "multiReleaseJarVersion": "9",
            "overlayTarget": "com.pthariensflame.satnq-clause.shell",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "dependencies": [
                "com.pthariensflame.satnq-clause.shell",
                "com.pthariensflame.satnq-clause.parser.jdk9",
                "com.pthariensflame.satnq-clause.lang.jdk9",
            ],
        },

        "com.pthariensflame.satnq-clause.parser": {
            "javaCompliance": "8",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "dependencies": [
                "SATNQ_ANTLR4_RUNTIME",
                "com.pthariensflame.satnq-clause.lang",
            ],
        },
        "com.pthariensflame.satnq-clause.parser.jdk9": {
            "javaCompliance": "9+",
            "multiReleaseJarVersion": "9",
            "overlayTarget": "com.pthariensflame.satnq-clause.parser",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "dependencies": [
                "com.pthariensflame.satnq-clause.parser",
                "com.pthariensflame.satnq-clause.lang.jdk9",
            ],
        },

        "com.pthariensflame.satnq-clause.lang": {
            "javaCompliance": "8",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "dependencies": [
                "SATNQ_ANTLR4_RUNTIME",
                "truffle:TRUFFLE_API",
                "sdk:GRAAL_SDK",
            ],
        },
        "com.pthariensflame.satnq-clause.lang.jdk9": {
            "javaCompliance": "9+",
            "multiReleaseJarVersion": "9",
            "overlayTarget": "com.pthariensflame.satnq-clause.lang",
            "annotationProcessors": ["truffle:TRUFFLE_DSL_PROCESSOR"],
            "dependencies": [
                "com.pthariensflame.satnq-clause.lang",
            ],
        },
    },

    "distributions": {
        "SATNQ_CLAUSE": {
            "moduleName": "com.pthariensflame.satnq_clause",
            "subDir": "src",
            "dependencies": [
                "com.pthariensflame.satnq-clause.lang.jdk9",
                "com.pthariensflame.satnq-clause.parser.jdk9",
                "com.pthariensflame.satnq-clause.shell.jdk9",
            ],
            "distDependencies": [
                "SATNQ_ANTLR4_RUNTIME",
                "truffle:TRUFFLE_API",
                "sdk:GRAAL_SDK",
            ],
            "maven": {
                "artifactId": "satnq-clause",
            },
            "description": """SatNQClause: A Truffle implementation of an open-world solver for hereditary Harrop \
            formulae over dependenly-sorted algebras with isomorphism.""",
            "allowsJavadocWarnings": True,
        },
    },
}
