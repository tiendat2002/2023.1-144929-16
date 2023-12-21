CREATE TABLE `timekeeper_app`.`user` (
    `id` INT NOT NULL ,
    `user_name` VARCHAR(255) NOT NULL ,
    `password` VARCHAR(255) NOT NULL ,
    `name` VARCHAR(255) NOT NULL ,
    `salary` VARCHAR(255) NOT NULL ,
    `birth_day` DATE NOT NULL ,
    `position` VARCHAR(255) NOT NULL ,
    `room` VARCHAR(255) NOT NULL,
    `department` VARCHAR(255) NOT NULL,
    `manager_id` INT NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`user_name`),
    FOREIGN KEY (`manager_id`) REFERENCES `admin`(`id`),
) ENGINE = InnoDB;

CREATE TABLE `timekeeper_app`.`calendar_client` (
                                                    `id` INT NOT NULL,
                                                    `user_id` INT NOT NULL,
                                                    `date` DATE NOT NULL,
                                                    `morning` INT DEFAULT 0,
                                                    `afternoon` INT DEFAULT 0,
                                                    `evening` INT DEFAULT 0,
                                                    `m_status` INT DEFAULT 0,
                                                    `a_status` INT DEFAULT 0,
                                                    `e_status` INT DEFAULT 0,
                                                    PRIMARY KEY (`id`),
                                                    UNIQUE (`user_id`),  -- corrected from `user_name`
                                                    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE = InnoDB;

CREATE TABLE `timekeeper_app`.`schedule_client` (
                                                    `id` INT NOT NULL,
                                                    `user_id` INT NOT NULL,
                                                    `date` DATE NOT NULL,
                                                    `time` TIME NOT NULL,
                                                    `part` INT DEFAULT 0,
                                                    `is_check` INT DEFAULT 0,
                                                    PRIMARY KEY (`id`),
                                                    UNIQUE (`user_id`),  -- corrected from `user_name`
                                                    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
) ENGINE = InnoDB;


-- create data
INSERT INTO `user`(`id`,`user_name`, `password`, `name`, `salary`, `birth_day`, `position`, `room`, `department`, `manager_id`) VALUES (1,'bao123','123456','Luu Duc Bao','5.000.000','15-12-2002','Employee','1th','Web developer',1);
INSERT INTO `schedule_client`(`user_id`, `date`, `time`, `session`, `is_check`, `type`) VALUES (1,'19-12-2023','9:00',0,1,0);