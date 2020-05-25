suite = {
    "name": "SatNQClause",
    "mxversion": "5.263.8",
    "versionConflictResolution": "latest",

    "groupId": "com.pthariensflame.satnq_clause",
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
                "version": "704a4b22febcc2d59848176b1b906742690f1fa6",
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
        "ORG_JETBRAINS_ANNOTATIONS": {
            "sha1": "efbff6752f67a7c9de3e4251c086a88e23591dfd",
            "maven": {
                "groupId": "org.jetbrains",
                "artifactId": "annotations",
                "version": "19.0.0",
            },
            "moduleName": "org.jetbrains.annotations",
        },

        "COM_IBM_ICU4J": {
            "sha1": "2e159807158095566726600534034030dddab6d0",
            "maven": {
                "groupId": "com.ibm.icu",
                "artifactId": "icu4j",
                "version": "67.1",
            },
            "moduleName": "com.ibm.icu",
        },

        "ORG_TYPEMETA_FUNCJ_CORE": {
            "sha1": "3d31df25aecdc54e422ee63556dce20374eee777",
            "maven": {
                "groupId": "org.typemeta",
                "artifactId": "funcj-core",
                "version": "0.6.15",
            },
            "moduleName": "org.typemeta.funcj.core",
        },
        "ORG_TYPEMETA_FUNCJ_PARSER": {
            "sha1": "c3bbd663d8ce8fb880f5dba57654518f2914a0bd",
            "maven": {
                "groupId": "org.typemeta",
                "artifactId": "funcj-parser",
                "version": "0.6.15",
            },
            "moduleName": "org.typemeta.funcj.parser",
        },

        "IO_KINDEDJ": {
            "sha1": "462731347602a3f24e3f21feec50928f9a657741",
            "maven": {
                "groupId": "io.kindedj",
                "artifactId": "kindedj",
                "version": "1.1.0",
            },
            "moduleName": "io.kindedj",
        },

        "ORG_JLINE_READER": {
            "sha1": "3ae8dbc62a23fd8ffbb2e389c6d5df2b50efa699",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-reader",
                "version": "3.14.1",
            },
            "moduleName": "org.jline.reader",
        },
        "ORG_JLINE_STYLE": {
            "sha1": "c20b8b8593c0f120f1a7a9916bf6cacf455f0c06",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-style",
                "version": "3.14.1",
            },
            "moduleName": "org.jline.style",
        },
        "ORG_JLINE_TERMINAL": {
            "sha1": "6eaf4f5a16d6250bc81b4fc046227e23e85d3783",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-terminal",
                "version": "3.14.1",
            },
            "moduleName": "org.jline.terminal",
        },
        "ORG_JLINE_TERMINAL_JANSI": {
            "sha1": "ad8f8a52ea0be842cbe75d0a184ba6c9b2a02900",
            "maven": {
                "groupId": "org.jline",
                "artifactId": "jline-terminal-jansi",
                "version": "3.14.1",
            },
            "moduleName": "org.jline.terminal.jansi",
        },

        "ORG_FUSESOURCE_JANSI": {
            "sha1": "d9205bbcd4b5f9cd1effe752d18f73bd942d783f",
            "maven": {
                "groupId": "org.fusesource.jansi",
                "artifactId": "jansi",
                "version": "1.18",
            },
            "moduleName": "org.fusesource.jansi",
        },
    },

    "projects": {
        "com.pthariensflame.satnq_clause.shell": {
            "subDir": "src",
            "sourceDirs": [
                "src",
            ],
            "javaCompliance": "8+",
            "annotationProcessors": [
                "truffle:TRUFFLE_DSL_PROCESSOR",
            ],
            "dependencies": [
                "ORG_JETBRAINS_ANNOTATIONS",
                "ORG_TYPEMETA_FUNCJ_CORE",
                "IO_KINDEDJ",
                "ORG_JLINE_READER",
                "ORG_JLINE_STYLE",
                "ORG_JLINE_TERMINAL",
                "ORG_JLINE_TERMINAL_JANSI",
                "ORG_FUSESOURCE_JANSI",
                "sdk:LAUNCHER_COMMON",
                "com.pthariensflame.satnq_clause.parser",
                "com.pthariensflame.satnq_clause.lang",
            ],
        },
        "com.pthariensflame.satnq_clause.shell.jdk11": {
            "subDir": "src",
            "sourceDirs": [
                "src",
            ],
            "javaCompliance": "11+",
            "multiReleaseJarVersion": "11",
            "overlayTarget": "com.pthariensflame.satnq_clause.shell",
            "annotationProcessors": [
                "truffle:TRUFFLE_DSL_PROCESSOR",
            ],
            "dependencies": [
                "ORG_JETBRAINS_ANNOTATIONS",
                "ORG_TYPEMETA_FUNCJ_CORE",
                "IO_KINDEDJ",
                "com.pthariensflame.satnq_clause.shell",
                "com.pthariensflame.satnq_clause.parser.jdk11",
                "com.pthariensflame.satnq_clause.lang.jdk11",
            ],
        },

        "com.pthariensflame.satnq_clause.parser": {
            "subDir": "src",
            "sourceDirs": [
                "src",
            ],
            "javaCompliance": "8+",
            "annotationProcessors": [
                "truffle:TRUFFLE_DSL_PROCESSOR",
            ],
            "dependencies": [
                "ORG_JETBRAINS_ANNOTATIONS",
                "ORG_TYPEMETA_FUNCJ_CORE",
                "ORG_TYPEMETA_FUNCJ_PARSER",
                "IO_KINDEDJ",
                "COM_IBM_ICU4J",
                "com.pthariensflame.satnq_clause.lang",
            ],
        },
        "com.pthariensflame.satnq_clause.parser.jdk11": {
            "subDir": "src",
            "sourceDirs": [
                "src",
            ],
            "javaCompliance": "11+",
            "multiReleaseJarVersion": "11",
            "overlayTarget": "com.pthariensflame.satnq_clause.parser",
            "annotationProcessors": [
                "truffle:TRUFFLE_DSL_PROCESSOR",
            ],
            "dependencies": [
                "ORG_JETBRAINS_ANNOTATIONS",
                "ORG_TYPEMETA_FUNCJ_CORE",
                "IO_KINDEDJ",
                "com.pthariensflame.satnq_clause.parser",
                "com.pthariensflame.satnq_clause.lang.jdk11",
            ],
        },

        "com.pthariensflame.satnq_clause.lang": {
            "subDir": "src",
            "sourceDirs": [
                "src",
            ],
            "javaCompliance": "8+",
            "annotationProcessors": [
                "truffle:TRUFFLE_DSL_PROCESSOR",
            ],
            "dependencies": [
                "ORG_JETBRAINS_ANNOTATIONS",
                "ORG_TYPEMETA_FUNCJ_CORE",
                "IO_KINDEDJ",
                "truffle:TRUFFLE_API",
                "sdk:GRAAL_SDK",
            ],
        },
        "com.pthariensflame.satnq_clause.lang.jdk11": {
            "subDir": "src",
            "sourceDirs": [
                "src",
            ],
            "javaCompliance": "11+",
            "multiReleaseJarVersion": "11",
            "overlayTarget": "com.pthariensflame.satnq_clause.lang",
            "annotationProcessors": [
                "truffle:TRUFFLE_DSL_PROCESSOR",
            ],
            "dependencies": [
                "ORG_JETBRAINS_ANNOTATIONS",
                "ORG_TYPEMETA_FUNCJ_CORE",
                "IO_KINDEDJ",
                "com.pthariensflame.satnq_clause.lang",
            ],
        },
    },

    "distributions": {
        "SATNQ_CLAUSE": {
            "subDir": "src",
            "moduleInfo": {
                "name": "com.pthariensflame.satnq_clause",
                "requires": [
                ],
                "exports": [
                    "com.pthariensflame.satnq_clause.nodes",
                    "com.pthariensflame.satnq_clause.lang",
                    "com.pthariensflame.satnq_clause.parser",
                    "com.pthariensflame.satnq_clause.shell",
                ],
                "opens": [
                    "com.pthariensflame.satnq_clause.nodes",
                    "com.pthariensflame.satnq_clause.lang",
                    "com.pthariensflame.satnq_clause.parser",
                    "com.pthariensflame.satnq_clause.shell",
                ],
                "uses": [
                ],
                "provides": {
                },
            },
            "dependencies": [
                "com.pthariensflame.satnq_clause.lang",
                "com.pthariensflame.satnq_clause.parser",
                "com.pthariensflame.satnq_clause.shell",
            ],
            "distDependencies": [
                "ORG_JETBRAINS_ANNOTATIONS",
                "ORG_TYPEMETA_FUNCJ_CORE",
                "ORG_TYPEMETA_FUNCJ_PARSER",
                "ORG_JLINE_READER",
                "ORG_JLINE_STYLE",
                "ORG_JLINE_TERMINAL",
                "ORG_JLINE_TERMINAL_JANSI",
                "ORG_FUSESOURCE_JANSI",
                "truffle:TRUFFLE_API",
                "sdk:GRAAL_SDK",
                "sdk:LAUNCHER_COMMON",
            ],
            "maven": {
                "artifactId": "satnq_clause",
            },
            "description": """SatNQClause: A Truffle implementation of an open-world solver for hereditary Harrop \
            formulae over dependenly-sorted algebras with isomorphism.""",
            "allowsJavadocWarnings": True,
        },
    },
}
