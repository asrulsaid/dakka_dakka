-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 26, 2021 at 12:37 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dakka`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `nama_user` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `foto_user` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `wisata`
--

CREATE TABLE `wisata` (
  `id_wisata` int(11) NOT NULL,
  `nama_wisata` varchar(255) NOT NULL,
  `kategori_wisata` varchar(255) NOT NULL,
  `deskripsi_wisata` text NOT NULL,
  `foto_wisata` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `wisata`
--

INSERT INTO `wisata` (`id_wisata`, `nama_wisata`, `kategori_wisata`, `deskripsi_wisata`, `foto_wisata`) VALUES
(1, 'Pantai Bira', 'Bahari', 'Pantai Bira memiliki hamparan pasir putih dan laut jernih yang memesona. Objek wisata ini tak pernah sepi dari pengunjung, baik lokal maupun mancanegara. Aktivitas seperti snorkeling dan diving pun sering dilakoni oleh wisatawan untuk menikmati keindahan bawah lautnya. Lokasinya berada di Kecamatan Bontobahari.', '/bira.jpg'),
(2, 'Pantai Losari', 'Bahari', 'Pantai Losari adalah sebuah pantai yang terletak di sebelah barat Kota Makassar, Provinsi Sulawesi Selatan, Indonesia. Pantai ini menjadi tempat bagi warga Makassar untuk menghabiskan waktu pada pagi, sore, dan malam hari menikmati pemandangan matahari tenggelam yang sangat indah.', '/losari.jpg'),
(3, 'Tamansuruh', 'Pertanian', 'Agro Wisata Tamansuruh merupakan destinasi wisata pertanian yang lagi hits di Banyuwangi. Berlokasi di Dusun Wonosari, Agro Wisata Tamansuruh menyuguhkan ragam hasil pertanian khas Banyuwangi seperti padi hitam, sayuran, dan buah-buahan organik.', 'tamansuruh.jpg');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- Indexes for table `wisata`
--
ALTER TABLE `wisata`
  ADD PRIMARY KEY (`id_wisata`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `wisata`
--
ALTER TABLE `wisata`
  MODIFY `id_wisata` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
