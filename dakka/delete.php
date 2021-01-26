<?php
	// header harus json
	// var_dump(file_get_contents('php://input'));
	// die;
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

	function status($kode, $pesan)
	{
		$result['status']['code'] = $kode;
		$result['status']['description'] = $pesan;

		return $result;
	}

	// pengecekan metode request
	if ($smethod=='GET') {

		$id_mhs = $_GET['id_mhs'];

		if(empty($id_mhs)){
			$result = status(200, 'Invalid Parameter');
		}else{
			// jika GET
			$result = status(200, 'Request Valid');

		    // ambil data
		    $sql = "DELETE FROM mahasiswa WHERE id_mhs = '$id_mhs'";
		    $hasilquery = $conn->query($sql);

		    // result
		    $result['status']['code'] = 200;
			$result['status']['description'] = "1 data deleted";
		}

	}else{
		// jika bukan GET
		$result = status(400, 'Request Invalid');
	}

	// parse ke format json
	echo json_encode($result);

?>