-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Время создания: Сен 21 2022 г., 00:29
-- Версия сервера: 5.7.39-log
-- Версия PHP: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База данных: `Mainproject`
--

-- --------------------------------------------------------

--
-- Структура таблицы `course`
--

CREATE TABLE `course` (
  `id` bigint(20) NOT NULL,
  `namecourse` varchar(255) DEFAULT NULL,
  `setting_course_id` bigint(20) DEFAULT NULL,
  `type_course_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `course`
--

INSERT INTO `course` (`id`, `namecourse`, `setting_course_id`, `type_course_id`) VALUES
(1, 'Java', 1, 1),
(3, 'ПП1', 1, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(5);

-- --------------------------------------------------------

--
-- Структура таблицы `ochenka`
--

CREATE TABLE `ochenka` (
  `id` bigint(20) NOT NULL,
  `data` varchar(255) DEFAULT NULL,
  `ochenka` varchar(255) DEFAULT NULL,
  `taskoc_id` bigint(20) DEFAULT NULL,
  `useroc_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `ochenka`
--

INSERT INTO `ochenka` (`id`, `data`, `ochenka`, `taskoc_id`, `useroc_id`) VALUES
(1, '21.09.2022', '5', 1, 1),
(2, '21.09.2022', '4', 4, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `passport`
--

CREATE TABLE `passport` (
  `id` bigint(20) NOT NULL,
  `date` varchar(30) DEFAULT NULL,
  `number` varchar(30) DEFAULT NULL,
  `seria` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `passport`
--

INSERT INTO `passport` (`id`, `date`, `number`, `seria`) VALUES
(2, '04 / 24', '567834', '2345');

-- --------------------------------------------------------

--
-- Структура таблицы `person`
--

CREATE TABLE `person` (
  `id` bigint(20) NOT NULL,
  `first_name` varchar(30) DEFAULT NULL,
  `middle_name` varchar(30) DEFAULT NULL,
  `name` varchar(30) DEFAULT NULL,
  `passport_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `person`
--

INSERT INTO `person` (`id`, `first_name`, `middle_name`, `name`, `passport_id`, `user_id`) VALUES
(1, 'Сальников', 'Борисович', 'Александр', 2, 1);

-- --------------------------------------------------------

--
-- Структура таблицы `setting_course`
--

CREATE TABLE `setting_course` (
  `id` bigint(20) NOT NULL,
  `background` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `setting_course`
--

INSERT INTO `setting_course` (`id`, `background`, `color`) VALUES
(1, 'Black', 'green');

-- --------------------------------------------------------

--
-- Структура таблицы `setting_task`
--

CREATE TABLE `setting_task` (
  `id` bigint(20) NOT NULL,
  `background` varchar(255) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `setting_task`
--

INSERT INTO `setting_task` (`id`, `background`, `color`) VALUES
(1, 'black', 'green');

-- --------------------------------------------------------

--
-- Структура таблицы `task`
--

CREATE TABLE `task` (
  `id` bigint(20) NOT NULL,
  `date` varchar(1000) DEFAULT NULL,
  `datesdacha` varchar(1000) DEFAULT NULL,
  `nametask` varchar(1000) DEFAULT NULL,
  `courses1_id` bigint(20) DEFAULT NULL,
  `setting_task_id` bigint(20) DEFAULT NULL,
  `type_task_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `task`
--

INSERT INTO `task` (`id`, `date`, `datesdacha`, `nametask`, `courses1_id`, `setting_task_id`, `type_task_id`) VALUES
(1, '19.09.2022', '20.09.2022', 'Сделать сайт1', 1, 1, 1),
(4, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `type_course`
--

CREATE TABLE `type_course` (
  `id` bigint(20) NOT NULL,
  `nametypec` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `type_course`
--

INSERT INTO `type_course` (`id`, `nametypec`) VALUES
(1, 'Програмирование');

-- --------------------------------------------------------

--
-- Структура таблицы `type_task`
--

CREATE TABLE `type_task` (
  `id` bigint(20) NOT NULL,
  `nametype` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `type_task`
--

INSERT INTO `type_task` (`id`, `nametype`) VALUES
(1, 'Материал');

-- --------------------------------------------------------

--
-- Структура таблицы `user`
--

CREATE TABLE `user` (
  `id` bigint(20) NOT NULL,
  `active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(15) DEFAULT NULL,
  `cour_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user`
--

INSERT INTO `user` (`id`, `active`, `password`, `username`, `cour_id`) VALUES
(1, b'1', '$2a$08$9TTHG8wvhxgcudc376IqaOTYT63ZBdrVraeD3W8eumSiG/LgN7v2G', 'Gwoop', 1),
(2, b'1', '$2a$08$m0tFvsaC8Efjwkt7e12Oaex42V9KN09xFv.qkMusYwcz5zq2bOKu6', 'Gwoop1', NULL),
(3, b'1', '$2a$08$028uDXpXx82aJGNXReUMnuVvNObFIg1Qa3YoO7VXScT3F1yjsQi.a', 'Gwoop2', NULL);

-- --------------------------------------------------------

--
-- Структура таблицы `user_role`
--

CREATE TABLE `user_role` (
  `user_id` bigint(20) NOT NULL,
  `roles` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Дамп данных таблицы `user_role`
--

INSERT INTO `user_role` (`user_id`, `roles`) VALUES
(1, 'USER'),
(1, 'ADMIN'),
(2, 'USER'),
(3, 'USER');

--
-- Индексы сохранённых таблиц
--

--
-- Индексы таблицы `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK1kvut28k4f66uua9ktle91358` (`setting_course_id`),
  ADD KEY `FK1kj0p9300wtnhkm4y54nx5wku` (`type_course_id`);

--
-- Индексы таблицы `ochenka`
--
ALTER TABLE `ochenka`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6r6vtswdcyv33cckdmdxidi` (`taskoc_id`),
  ADD KEY `FKns8ac4f5da00agqt79wbi3afs` (`useroc_id`);

--
-- Индексы таблицы `passport`
--
ALTER TABLE `passport`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKpm70pbnghc1m7eq6n4jf5fkd` (`passport_id`),
  ADD KEY `FK2is3ph79mqcwtkd724syhtjbi` (`user_id`);

--
-- Индексы таблицы `setting_course`
--
ALTER TABLE `setting_course`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `setting_task`
--
ALTER TABLE `setting_task`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK201wlvhcvep66bts565o4mo02` (`courses1_id`),
  ADD KEY `FK4k9f1bol8a3g52pwui8oyt3dj` (`setting_task_id`),
  ADD KEY `FK43vkm1mowi61qf8ejg8d0up5g` (`type_task_id`);

--
-- Индексы таблицы `type_course`
--
ALTER TABLE `type_course`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `type_task`
--
ALTER TABLE `type_task`
  ADD PRIMARY KEY (`id`);

--
-- Индексы таблицы `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4cys0fdi1abxol4w3emrmrq4k` (`cour_id`);

--
-- Индексы таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`);

--
-- AUTO_INCREMENT для сохранённых таблиц
--

--
-- AUTO_INCREMENT для таблицы `ochenka`
--
ALTER TABLE `ochenka`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `passport`
--
ALTER TABLE `passport`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT для таблицы `person`
--
ALTER TABLE `person`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT для таблицы `user`
--
ALTER TABLE `user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `course`
--
ALTER TABLE `course`
  ADD CONSTRAINT `FK1kj0p9300wtnhkm4y54nx5wku` FOREIGN KEY (`type_course_id`) REFERENCES `type_course` (`id`),
  ADD CONSTRAINT `FK1kvut28k4f66uua9ktle91358` FOREIGN KEY (`setting_course_id`) REFERENCES `setting_course` (`id`);

--
-- Ограничения внешнего ключа таблицы `ochenka`
--
ALTER TABLE `ochenka`
  ADD CONSTRAINT `FK6r6vtswdcyv33cckdmdxidi` FOREIGN KEY (`taskoc_id`) REFERENCES `task` (`id`),
  ADD CONSTRAINT `FKns8ac4f5da00agqt79wbi3afs` FOREIGN KEY (`useroc_id`) REFERENCES `user` (`id`);

--
-- Ограничения внешнего ключа таблицы `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `FK2is3ph79mqcwtkd724syhtjbi` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  ADD CONSTRAINT `FKpm70pbnghc1m7eq6n4jf5fkd` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`);

--
-- Ограничения внешнего ключа таблицы `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `FK201wlvhcvep66bts565o4mo02` FOREIGN KEY (`courses1_id`) REFERENCES `course` (`id`),
  ADD CONSTRAINT `FK43vkm1mowi61qf8ejg8d0up5g` FOREIGN KEY (`type_task_id`) REFERENCES `type_task` (`id`),
  ADD CONSTRAINT `FK4k9f1bol8a3g52pwui8oyt3dj` FOREIGN KEY (`setting_task_id`) REFERENCES `setting_task` (`id`);

--
-- Ограничения внешнего ключа таблицы `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `FK4cys0fdi1abxol4w3emrmrq4k` FOREIGN KEY (`cour_id`) REFERENCES `course` (`id`);

--
-- Ограничения внешнего ключа таблицы `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
