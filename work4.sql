/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 8.3.0 : Database - work4
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`work4` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `work4`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `videoId` int NOT NULL,
  `userId` int NOT NULL,
  `commentText` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `parentCommentId` int DEFAULT NULL,
  `commentTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `comment` */

insert  into `comment`(`videoId`,`userId`,`commentText`,`parentCommentId`,`commentTime`) values (3,5,'25',2252,'2024-03-12 13:23:00'),(2,2,'666啊家人们',NULL,'2024-03-10 14:04:48'),(2,2,'666啊家人们',3,'2024-03-10 14:07:24');

/*Table structure for table `relationship` */

DROP TABLE IF EXISTS `relationship`;

CREATE TABLE `relationship` (
  `userId` int NOT NULL,
  `followedUserId` int NOT NULL,
  UNIQUE KEY `unique_relationship` (`userId`,`followedUserId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `relationship` */

insert  into `relationship`(`userId`,`followedUserId`) values (1,2),(1,3),(1,5),(2,1),(2,3),(3,1),(4,1);

/*Table structure for table `searchhistory` */

DROP TABLE IF EXISTS `searchhistory`;

CREATE TABLE `searchhistory` (
  `user_id` int NOT NULL,
  `searchKeyword` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `searchTime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `searchhistory` */

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int unsigned NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `avatar_url` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`password`,`email`,`avatar_url`) values (1,'阿哲','42542','4524524','542542'),(2,'奋斗','4527527','453254','453434'),(3,'圣主','45235434','4536456345','4564566'),(2088763392,'张伟','967482','askfhjsakfhjkhfsa','asfhsakjfhkj');

/*Table structure for table `video` */

DROP TABLE IF EXISTS `video`;

CREATE TABLE `video` (
  `videoId` int unsigned NOT NULL AUTO_INCREMENT,
  `videoUrl` varchar(1000) NOT NULL,
  `description` varchar(1000) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `uploadTime` datetime NOT NULL,
  `viewsCount` int NOT NULL,
  `userId` int NOT NULL,
  `type` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`videoId`)
) ENGINE=InnoDB AUTO_INCREMENT=453 DEFAULT CHARSET=utf8mb3;

/*Data for the table `video` */

insert  into `video`(`videoId`,`videoUrl`,`description`,`uploadTime`,`viewsCount`,`userId`,`type`) values (1,'http:abcdefg','第三名','2024-03-10 13:34:21',0,1,NULL),(2,'452452452','第一名','2024-03-22 17:24:44',452452452,45254242,NULL),(3,'452452','第二名','2024-01-03 17:24:52',254224,2525252,'搞笑');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
