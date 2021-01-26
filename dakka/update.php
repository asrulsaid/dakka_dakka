<?php
	// header harus json
	header("Content-Type:application/json");

	// conf koneksi db
	$servername = "localhost";
    $username = "root";
    $password = "";
    $dbnamea = "mahasiswa";

    // Create connection
    $conn = new mysqli($servername, $username, $password, $dbnamea);

	// tangkap method request
	$smethod = $_SERVER['REQUEST_METHOD'];

	// inisialisasi variable hasil
	$result = array();

	// kondisi metode
	if($smethod == 'POST'){
		// tangkap input
		$nim = $_POST['nim'];
		$nama_mhs = $_POST['nama_mhs'];
		$alamat = $_POST['alamat'];
		$id_mhs = $_POST['id_mhs'];

		// insert data
		$sql = "UPDATE mahasiswa SET
					nim = '$nim',
					nama_mhs = '$nama_mhs', 
					alamat = '$alamat', 
					foto = '' 
				WHERE id_mhs = '$id_mhs'";
		$conn->query($sql);

		$result['status']['code'] = 200;
		$result['status']['description'] = "1 data updated";
		$result['result'] = array(
			"nim"=>$nim,
			"nama_mhs"=>$nama_mhs,
			"alamat"=>$alamat
		);

	}else{
		$result['status']['code'] = 400;
	}

	// parse ke format json
	echo json_encode($result);
?>