package exercises;

public class DataUtil {

    static final String users_ = """ 
            [
               {
                 "id": 1,
                 "username": "Bret",
                 "email": "qwe@gmail.com"
               },
               {
                 "id": 2,
                 "username": "Antonette",
                 "email": "qaz@gmail.com"
               },
               {
                 "id": 3,
                 "username": "Samantha",
                 "email": "zxc@gmail.com"
               },
               {
                 "id": 4,
                 "username": "Karianne",
                 "email": "dfg@gmal.com"
               },
               {
                 "id": 5,
                 "username": "Kamren",
                 "email": "adg@gmail.com"
               }
             ]
                            
                """;
    static final String albums_ = """
                   [
                      {
                        "userId": 1,
                        "id": 1,
                        "title": "quidem molestiae enim"
                      },
                      {
                        "userId": 1,
                        "id": 2,
                        "title": "sunt qui excepturi placeat culpa"
                      },
                      {
                        "userId": 1,
                        "id": 3,
                        "title": "omnis laborum odio"
                      },
                      {
                        "userId": 1,
                        "id": 4,
                        "title": "non esse culpa molestiae omnis sed optio"
                      },
                      {
                        "userId": 1,
                        "id": 5,
                        "title": "eaque aut omnis a"
                      },
                      {
                        "userId": 1,
                        "id": 6,
                        "title": "natus impedit quibusdam illo est"
                      },
                      {
                        "userId": 1,
                        "id": 7,
                        "title": "quibusdam autem aliquid et et quia"
                      },
                      {
                        "userId": 1,
                        "id": 8,
                        "title": "qui fuga est a eum"
                      },
                      {
                        "userId": 1,
                        "id": 9,
                        "title": "saepe unde necessitatibus rem"
                      },
                      {
                        "userId": 1,
                        "id": 10,
                        "title": "distinctio laborum qui"
                      },
                      {
                        "userId": 2,
                        "id": 11,
                        "title": "quam nostrum impedit mollitia quod et dolor"
                      },
                      {
                        "userId": 2,
                        "id": 12,
                        "title": "consequatur autem doloribus natus consectetur"
                      },
                      {
                        "userId": 2,
                        "id": 13,
                        "title": "ab rerum non rerum consequatur ut ea unde"
                      },
                      {
                        "userId": 2,
                        "id": 14,
                        "title": "ducimus molestias eos animi atque nihil"
                      },
                      {
                        "userId": 2,
                        "id": 15,
                        "title": "ut pariatur rerum ipsum natus repellendus praesentium"
                      },
                      {
                        "userId": 2,
                        "id": 16,
                        "title": "voluptatem aut maxime inventore autem magnam atque repellat"
                      },
                      {
                        "userId": 2,
                        "id": 17,
                        "title": "aut minima voluptatem ut velit"
                      },
                      {
                        "userId": 2,
                        "id": 18,
                        "title": "nesciunt quia et doloremque"
                      },
                      {
                        "userId": 2,
                        "id": 19,
                        "title": "velit pariatur quaerat similique libero omnis quia"
                      },
                      {
                        "userId": 2,
                        "id": 20,
                        "title": "voluptas rerum iure ut enim"
                      },
                      {
                        "userId": 3,
                        "id": 21,
                        "title": "repudiandae voluptatem optio est consequatur rem in temporibus et"
                      },
                      {
                        "userId": 3,
                        "id": 22,
                        "title": "et rem non provident vel ut"
                      },
                      {
                        "userId": 3,
                        "id": 23,
                        "title": "incidunt quisquam hic adipisci sequi"
                      },
                      {
                        "userId": 3,
                        "id": 24,
                        "title": "dolores ut et facere placeat"
                      },
                      {
                        "userId": 3,
                        "id": 25,
                        "title": "vero maxime id possimus sunt neque et consequatur"
                      },
                      {
                        "userId": 3,
                        "id": 26,
                        "title": "quibusdam saepe ipsa vel harum"
                      },
                      {
                        "userId": 3,
                        "id": 27,
                        "title": "id non nostrum expedita"
                      },
                      {
                        "userId": 3,
                        "id": 28,
                        "title": "omnis neque exercitationem sed dolor atque maxime aut cum"
                      },
                      {
                        "userId": 3,
                        "id": 29,
                        "title": "inventore ut quasi magnam itaque est fugit"
                      },
                      {
                        "userId": 3,
                        "id": 30,
                        "title": "tempora assumenda et similique odit distinctio error"
                      },
                      {
                        "userId": 4,
                        "id": 31,
                        "title": "adipisci laborum fuga laboriosam"
                      },
                      {
                        "userId": 4,
                        "id": 32,
                        "title": "reiciendis dolores a ut qui debitis non quo labore"
                      },
                      {
                        "userId": 4,
                        "id": 33,
                        "title": "iste eos nostrum"
                      },
                      {
                        "userId": 4,
                        "id": 34,
                        "title": "cumque voluptatibus rerum architecto blanditiis"
                      },
                      {
                        "userId": 4,
                        "id": 35,
                        "title": "et impedit nisi quae magni necessitatibus sed aut pariatur"
                      },
                      {
                        "userId": 4,
                        "id": 36,
                        "title": "nihil cupiditate voluptate neque"
                      },
                      {
                        "userId": 4,
                        "id": 37,
                        "title": "est placeat dicta ut nisi rerum iste"
                      },
                      {
                        "userId": 4,
                        "id": 38,
                        "title": "unde a sequi id"
                      },
                      {
                        "userId": 4,
                        "id": 39,
                        "title": "ratione porro illum labore eum aperiam sed"
                      },
                      {
                        "userId": 4,
                        "id": 40,
                        "title": "voluptas neque et sint aut quo odit"
                      },
                      {
                        "userId": 5,
                        "id": 41,
                        "title": "ea voluptates maiores eos accusantium officiis tempore mollitia consequatur"
                      },
                      {
                        "userId": 5,
                        "id": 42,
                        "title": "tenetur explicabo ea"
                      },
                      {
                        "userId": 5,
                        "id": 43,
                        "title": "aperiam doloremque nihil"
                      },
                      {
                        "userId": 5,
                        "id": 44,
                        "title": "sapiente cum numquam officia consequatur vel natus quos suscipit"
                      },
                      {
                        "userId": 5,
                        "id": 45,
                        "title": "tenetur quos ea unde est enim corrupti qui"
                      },
                      {
                        "userId": 5,
                        "id": 46,
                        "title": "molestiae voluptate non"
                      },
                      {
                        "userId": 5,
                        "id": 47,
                        "title": "temporibus molestiae aut"
                      },
                      {
                        "userId": 5,
                        "id": 48,
                        "title": "modi consequatur culpa aut quam soluta alias perspiciatis laudantium"
                      },
                      {
                        "userId": 5,
                        "id": 49,
                        "title": "ut aut vero repudiandae voluptas ullam voluptas at consequatur"
                      },
                      {
                        "userId": 5,
                        "id": 50,
                        "title": "sed qui sed quas sit ducimus dolor"
                      },
                      {
                        "userId": 6,
                        "id": 51,
                        "title": "odit laboriosam sint quia cupiditate animi quis"
                      },
                      {
                        "userId": 6,
                        "id": 52,
                        "title": "necessitatibus quas et sunt at voluptatem"
                      },
                      {
                        "userId": 6,
                        "id": 53,
                        "title": "est vel sequi voluptatem nemo quam molestiae modi enim"
                      },
                      {
                        "userId": 6,
                        "id": 54,
                        "title": "aut non illo amet perferendis"
                      },
                      {
                        "userId": 6,
                        "id": 55,
                        "title": "qui culpa itaque omnis in nesciunt architecto error"
                      },
                      {
                        "userId": 6,
                        "id": 56,
                        "title": "omnis qui maiores tempora officiis omnis rerum sed repellat"
                      },
                      {
                        "userId": 6,
                        "id": 57,
                        "title": "libero excepturi voluptatem est architecto quae voluptatum officia tempora"
                      },
                      {
                        "userId": 6,
                        "id": 58,
                        "title": "nulla illo consequatur aspernatur veritatis aut error delectus et"
                      },
                      {
                        "userId": 6,
                        "id": 59,
                        "title": "eligendi similique provident nihil"
                      },
                      {
                        "userId": 6,
                        "id": 60,
                        "title": "omnis mollitia sunt aliquid eum consequatur fugit minus laudantium"
                      },
                      {
                        "userId": 7,
                        "id": 61,
                        "title": "delectus iusto et"
                      },
                      {
                        "userId": 7,
                        "id": 62,
                        "title": "eos ea non recusandae iste ut quasi"
                      },
                      {
                        "userId": 7,
                        "id": 63,
                        "title": "velit est quam"
                      },
                      {
                        "userId": 7,
                        "id": 64,
                        "title": "autem voluptatem amet iure quae"
                      },
                      {
                        "userId": 7,
                        "id": 65,
                        "title": "voluptates delectus iure iste qui"
                      },
                      {
                        "userId": 7,
                        "id": 66,
                        "title": "velit sed quia dolor dolores delectus"
                      },
                      {
                        "userId": 7,
                        "id": 67,
                        "title": "ad voluptas nostrum et nihil"
                      },
                      {
                        "userId": 7,
                        "id": 68,
                        "title": "qui quasi nihil aut voluptatum sit dolore minima"
                      },
                      {
                        "userId": 7,
                        "id": 69,
                        "title": "qui aut est"
                      },
                      {
                        "userId": 7,
                        "id": 70,
                        "title": "et deleniti unde"
                      },
                      {
                        "userId": 8,
                        "id": 71,
                        "title": "et vel corporis"
                      },
                      {
                        "userId": 8,
                        "id": 72,
                        "title": "unde exercitationem ut"
                      },
                      {
                        "userId": 8,
                        "id": 73,
                        "title": "quos omnis officia"
                      },
                      {
                        "userId": 8,
                        "id": 74,
                        "title": "quia est eius vitae dolor"
                      },
                      {
                        "userId": 8,
                        "id": 75,
                        "title": "aut quia expedita non"
                      },
                      {
                        "userId": 8,
                        "id": 76,
                        "title": "dolorem magnam facere itaque ut reprehenderit tenetur corrupti"
                      },
                      {
                        "userId": 8,
                        "id": 77,
                        "title": "cupiditate sapiente maiores iusto ducimus cum excepturi veritatis quia"
                      },
                      {
                        "userId": 8,
                        "id": 78,
                        "title": "est minima eius possimus ea ratione velit et"
                      },
                      {
                        "userId": 8,
                        "id": 79,
                        "title": "ipsa quae voluptas natus ut suscipit soluta quia quidem"
                      },
                      {
                        "userId": 8,
                        "id": 80,
                        "title": "id nihil reprehenderit"
                      },
                      {
                        "userId": 9,
                        "id": 81,
                        "title": "quibusdam sapiente et"
                      },
                      {
                        "userId": 9,
                        "id": 82,
                        "title": "recusandae consequatur vel amet unde"
                      },
                      {
                        "userId": 9,
                        "id": 83,
                        "title": "aperiam odio fugiat"
                      },
                      {
                        "userId": 9,
                        "id": 84,
                        "title": "est et at eos expedita"
                      },
                      {
                        "userId": 9,
                        "id": 85,
                        "title": "qui voluptatem consequatur aut ab quis temporibus praesentium"
                      },
                      {
                        "userId": 9,
                        "id": 86,
                        "title": "eligendi mollitia alias aspernatur vel ut iusto"
                      },
                      {
                        "userId": 9,
                        "id": 87,
                        "title": "aut aut architecto"
                      },
                      {
                        "userId": 9,
                        "id": 88,
                        "title": "quas perspiciatis optio"
                      },
                      {
                        "userId": 9,
                        "id": 89,
                        "title": "sit optio id voluptatem est eum et"
                      },
                      {
                        "userId": 9,
                        "id": 90,
                        "title": "est vel dignissimos"
                      },
                      {
                        "userId": 10,
                        "id": 91,
                        "title": "repellendus praesentium debitis officiis"
                      },
                      {
                        "userId": 10,
                        "id": 92,
                        "title": "incidunt et et eligendi assumenda soluta quia recusandae"
                      },
                      {
                        "userId": 10,
                        "id": 93,
                        "title": "nisi qui dolores perspiciatis"
                      },
                      {
                        "userId": 10,
                        "id": 94,
                        "title": "quisquam a dolores et earum vitae"
                      },
                      {
                        "userId": 10,
                        "id": 95,
                        "title": "consectetur vel rerum qui aperiam modi eos aspernatur ipsa"
                      },
                      {
                        "userId": 10,
                        "id": 96,
                        "title": "unde et ut molestiae est molestias voluptatem sint"
                      },
                      {
                        "userId": 10,
                        "id": 97,
                        "title": "est quod aut"
                      },
                      {
                        "userId": 10,
                        "id": 98,
                        "title": "omnis quia possimus nesciunt deleniti assumenda sed autem"
                      },
                      {
                        "userId": 10,
                        "id": 99,
                        "title": "consectetur ut id impedit dolores sit ad ex aut"
                      },
                      {
                        "userId": 10,
                        "id": 100,
                        "title": "enim repellat iste"
                      }
                    ] 
                          
            """;
    static final String photo_ = """
            [
              {
                "albumId": 35,
                "id": 1701,
                "title": "est voluptatibus corporis modi est",
                "url": "https://via.placeholder.com/600/443482",
                "thumbnailUrl": "https://via.placeholder.com/150/443482"
              },
              {
                "albumId": 35,
                "id": 1702,
                "title": "voluptatem ut nulla",
                "url": "https://via.placeholder.com/600/96324f",
                "thumbnailUrl": "https://via.placeholder.com/150/96324f"
              },
              {
                "albumId": 35,
                "id": 1703,
                "title": "iste molestiae et non sint",
                "url": "https://via.placeholder.com/600/e8322",
                "thumbnailUrl": "https://via.placeholder.com/150/e8322"
              },
              {
                "albumId": 35,
                "id": 1704,
                "title": "voluptate cum fugit",
                "url": "https://via.placeholder.com/600/c701dd",
                "thumbnailUrl": "https://via.placeholder.com/150/c701dd"
              },
              {
                "albumId": 35,
                "id": 1705,
                "title": "tenetur itaque omnis est excepturi",
                "url": "https://via.placeholder.com/600/7cce1c",
                "thumbnailUrl": "https://via.placeholder.com/150/7cce1c"
              },
              {
                "albumId": 35,
                "id": 1706,
                "title": "est qui beatae debitis rerum dolore",
                "url": "https://via.placeholder.com/600/4771f1",
                "thumbnailUrl": "https://via.placeholder.com/150/4771f1"
              },
              {
                "albumId": 35,
                "id": 1707,
                "title": "sed quidem qui culpa enim",
                "url": "https://via.placeholder.com/600/f9e3b5",
                "thumbnailUrl": "https://via.placeholder.com/150/f9e3b5"
              },
              {
                "albumId": 35,
                "id": 1708,
                "title": "consequatur laudantium porro facilis earum quia vero quo",
                "url": "https://via.placeholder.com/600/e8dd61",
                "thumbnailUrl": "https://via.placeholder.com/150/e8dd61"
              },
              {
                "albumId": 35,
                "id": 1709,
                "title": "qui quo corrupti consequatur accusamus occaecati",
                "url": "https://via.placeholder.com/600/be458b",
                "thumbnailUrl": "https://via.placeholder.com/150/be458b"
              },
              {
                "albumId": 35,
                "id": 1710,
                "title": "molestiae harum aut",
                "url": "https://via.placeholder.com/600/4e0df",
                "thumbnailUrl": "https://via.placeholder.com/150/4e0df"
              },
              {
                "albumId": 35,
                "id": 1711,
                "title": "suscipit veniam id",
                "url": "https://via.placeholder.com/600/3d4ccc",
                "thumbnailUrl": "https://via.placeholder.com/150/3d4ccc"
              },
              {
                "albumId": 35,
                "id": 1712,
                "title": "nostrum maxime sed sunt accusamus qui vel",
                "url": "https://via.placeholder.com/600/b881d4",
                "thumbnailUrl": "https://via.placeholder.com/150/b881d4"
              },
              {
                "albumId": 35,
                "id": 1713,
                "title": "nemo doloremque itaque quis ad id",
                "url": "https://via.placeholder.com/600/8f2cdc",
                "thumbnailUrl": "https://via.placeholder.com/150/8f2cdc"
              },
              {
                "albumId": 35,
                "id": 1714,
                "title": "veniam autem deserunt et id explicabo vel ut",
                "url": "https://via.placeholder.com/600/7e0946",
                "thumbnailUrl": "https://via.placeholder.com/150/7e0946"
              },
              {
                "albumId": 35,
                "id": 1715,
                "title": "veritatis eligendi voluptatem optio enim libero unde rerum",
                "url": "https://via.placeholder.com/600/71d928",
                "thumbnailUrl": "https://via.placeholder.com/150/71d928"
              },
              {
                "albumId": 35,
                "id": 1716,
                "title": "libero perspiciatis excepturi ullam et",
                "url": "https://via.placeholder.com/600/6b3985",
                "thumbnailUrl": "https://via.placeholder.com/150/6b3985"
              },
              {
                "albumId": 35,
                "id": 1717,
                "title": "exercitationem sunt eum qui quibusdam non dolores et reiciendis",
                "url": "https://via.placeholder.com/600/ff2e53",
                "thumbnailUrl": "https://via.placeholder.com/150/ff2e53"
              },
              {
                "albumId": 35,
                "id": 1718,
                "title": "voluptate dolorem est",
                "url": "https://via.placeholder.com/600/43166d",
                "thumbnailUrl": "https://via.placeholder.com/150/43166d"
              },
              {
                "albumId": 35,
                "id": 1719,
                "title": "enim quis nostrum consectetur laborum numquam",
                "url": "https://via.placeholder.com/600/cd6e87",
                "thumbnailUrl": "https://via.placeholder.com/150/cd6e87"
              },
              {
                "albumId": 35,
                "id": 1720,
                "title": "cum odit suscipit eaque est facilis qui nam beatae",
                "url": "https://via.placeholder.com/600/22335c",
                "thumbnailUrl": "https://via.placeholder.com/150/22335c"
              },
              {
                "albumId": 35,
                "id": 1721,
                "title": "numquam facere quia totam atque assumenda",
                "url": "https://via.placeholder.com/600/5b5f93",
                "thumbnailUrl": "https://via.placeholder.com/150/5b5f93"
              },
              {
                "albumId": 35,
                "id": 1722,
                "title": "ut pariatur qui asperiores similique",
                "url": "https://via.placeholder.com/600/117d9e",
                "thumbnailUrl": "https://via.placeholder.com/150/117d9e"
              },
              {
                "albumId": 35,
                "id": 1723,
                "title": "est qui voluptatum ad",
                "url": "https://via.placeholder.com/600/9807ac",
                "thumbnailUrl": "https://via.placeholder.com/150/9807ac"
              },
              {
                "albumId": 35,
                "id": 1724,
                "title": "reiciendis tempore minima voluptas sint dolores",
                "url": "https://via.placeholder.com/600/dab44b",
                "thumbnailUrl": "https://via.placeholder.com/150/dab44b"
              },
              {
                "albumId": 35,
                "id": 1725,
                "title": "et sit dolor laudantium illo voluptatibus similique saepe nesciunt",
                "url": "https://via.placeholder.com/600/3d2e3d",
                "thumbnailUrl": "https://via.placeholder.com/150/3d2e3d"
              },
              {
                "albumId": 35,
                "id": 1726,
                "title": "qui placeat et nemo molestiae",
                "url": "https://via.placeholder.com/600/af8e83",
                "thumbnailUrl": "https://via.placeholder.com/150/af8e83"
              },
              {
                "albumId": 35,
                "id": 1727,
                "title": "non in quia rerum fugiat commodi",
                "url": "https://via.placeholder.com/600/43efff",
                "thumbnailUrl": "https://via.placeholder.com/150/43efff"
              },
              {
                "albumId": 35,
                "id": 1728,
                "title": "non sint est",
                "url": "https://via.placeholder.com/600/6e1979",
                "thumbnailUrl": "https://via.placeholder.com/150/6e1979"
              },
              {
                "albumId": 35,
                "id": 1729,
                "title": "deserunt perferendis sed rerum",
                "url": "https://via.placeholder.com/600/2a7fbf",
                "thumbnailUrl": "https://via.placeholder.com/150/2a7fbf"
              },
              {
                "albumId": 35,
                "id": 1730,
                "title": "modi incidunt sed ut",
                "url": "https://via.placeholder.com/600/2fb19c",
                "thumbnailUrl": "https://via.placeholder.com/150/2fb19c"
              },
              {
                "albumId": 35,
                "id": 1731,
                "title": "ratione harum expedita nihil nesciunt laudantium et ut",
                "url": "https://via.placeholder.com/600/f6bb1b",
                "thumbnailUrl": "https://via.placeholder.com/150/f6bb1b"
              },
              {
                "albumId": 35,
                "id": 1732,
                "title": "pariatur sunt eveniet",
                "url": "https://via.placeholder.com/600/400978",
                "thumbnailUrl": "https://via.placeholder.com/150/400978"
              },
              {
                "albumId": 35,
                "id": 1733,
                "title": "rerum qui repellendus neque delectus",
                "url": "https://via.placeholder.com/600/924b68",
                "thumbnailUrl": "https://via.placeholder.com/150/924b68"
              },
              {
                "albumId": 35,
                "id": 1734,
                "title": "sapiente hic omnis libero",
                "url": "https://via.placeholder.com/600/59c019",
                "thumbnailUrl": "https://via.placeholder.com/150/59c019"
              },
              {
                "albumId": 35,
                "id": 1735,
                "title": "aut illum porro vel harum est exercitationem nam",
                "url": "https://via.placeholder.com/600/ef2d7c",
                "thumbnailUrl": "https://via.placeholder.com/150/ef2d7c"
              },
              {
                "albumId": 35,
                "id": 1736,
                "title": "dolorum eaque eos",
                "url": "https://via.placeholder.com/600/73462e",
                "thumbnailUrl": "https://via.placeholder.com/150/73462e"
              },
              {
                "albumId": 35,
                "id": 1737,
                "title": "facere sed eum aspernatur nulla",
                "url": "https://via.placeholder.com/600/34fe75",
                "thumbnailUrl": "https://via.placeholder.com/150/34fe75"
              },
              {
                "albumId": 35,
                "id": 1738,
                "title": "ratione quia cumque",
                "url": "https://via.placeholder.com/600/3c9376",
                "thumbnailUrl": "https://via.placeholder.com/150/3c9376"
              },
              {
                "albumId": 35,
                "id": 1739,
                "title": "aut consequuntur occaecati non doloribus laborum animi enim",
                "url": "https://via.placeholder.com/600/b730f7",
                "thumbnailUrl": "https://via.placeholder.com/150/b730f7"
              },
              {
                "albumId": 35,
                "id": 1740,
                "title": "quidem aperiam recusandae assumenda nostrum",
                "url": "https://via.placeholder.com/600/a226ba",
                "thumbnailUrl": "https://via.placeholder.com/150/a226ba"
              },
              {
                "albumId": 35,
                "id": 1741,
                "title": "atque est voluptatum accusamus natus deleniti",
                "url": "https://via.placeholder.com/600/e42e20",
                "thumbnailUrl": "https://via.placeholder.com/150/e42e20"
              },
              {
                "albumId": 35,
                "id": 1742,
                "title": "iste non iure harum a",
                "url": "https://via.placeholder.com/600/3fae7",
                "thumbnailUrl": "https://via.placeholder.com/150/3fae7"
              },
              {
                "albumId": 35,
                "id": 1743,
                "title": "non placeat sequi sed numquam rerum delectus minima",
                "url": "https://via.placeholder.com/600/e92278",
                "thumbnailUrl": "https://via.placeholder.com/150/e92278"
              },
              {
                "albumId": 35,
                "id": 1744,
                "title": "exercitationem hic maiores expedita quae quia",
                "url": "https://via.placeholder.com/600/133ca0",
                "thumbnailUrl": "https://via.placeholder.com/150/133ca0"
              },
              {
                "albumId": 35,
                "id": 1745,
                "title": "dolorum mollitia atque velit corporis",
                "url": "https://via.placeholder.com/600/bf8826",
                "thumbnailUrl": "https://via.placeholder.com/150/bf8826"
              },
              {
                "albumId": 35,
                "id": 1746,
                "title": "consequatur ea cupiditate qui officiis amet est officia magnam",
                "url": "https://via.placeholder.com/600/570847",
                "thumbnailUrl": "https://via.placeholder.com/150/570847"
              },
              {
                "albumId": 35,
                "id": 1747,
                "title": "sequi in aut nam voluptatem perferendis",
                "url": "https://via.placeholder.com/600/fd2e85",
                "thumbnailUrl": "https://via.placeholder.com/150/fd2e85"
              },
              {
                "albumId": 35,
                "id": 1748,
                "title": "sunt quo exercitationem molestias corporis et soluta odio",
                "url": "https://via.placeholder.com/600/3b5fa3",
                "thumbnailUrl": "https://via.placeholder.com/150/3b5fa3"
              },
              {
                "albumId": 35,
                "id": 1749,
                "title": "fuga asperiores qui alias",
                "url": "https://via.placeholder.com/600/efb648",
                "thumbnailUrl": "https://via.placeholder.com/150/efb648"
              },
              {
                "albumId": 35,
                "id": 1750,
                "title": "in totam veritatis itaque iusto eaque perspiciatis libero deleniti",
                "url": "https://via.placeholder.com/600/31fdae",
                "thumbnailUrl": "https://via.placeholder.com/150/31fdae"
              }
            ]
            """;
}
