Step1: Create Datatbase:

CREATE TABLE db_work.`work` (
  `id` int NOT NULL AUTO_INCREMENT,
  `work_name` varchar(255) NULL DEFAULT NULL,
  `start_date` date NULL DEFAULT NULL,
  `end_date` date NULL DEFAULT NULL,
  `status` varchar(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO db_work.`work` VALUES (1, 'daily report', '2022-06-01', '2022-07-01', 'Doing')


Step2: 
*list api:
 - add work: http://localhost:8080/api/works/addWork
 - edit work: http://localhost:8080/api/works/editWork/{id}
 - delete work: http://localhost:8080/api/works/deleteWork/{id}
 - list all works, sort and paging:
     http://localhost:8080/api/works/getWorksList
     http://localhost:8080/api/works/getWorksList?sortBy=status&page=0
     http://localhost:8080/api/works/getWorksList?sortBy=status&page=1
     http://localhost:8080/api/works/getWorksList?sortBy=workName&page=0
     http://localhost:8080/api/works/getWorksList?sortBy=workName&page=1
     http://localhost:8080/api/works/getWorksList?sortBy=startDate&page=0
     http://localhost:8080/api/works/getWorksList?sortBy=startDate&page=1