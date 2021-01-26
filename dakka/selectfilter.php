<?php
	// header harus json
	// var_dump(file_get_contents('php://input'));
	// die;
	header("Content-Type:application/json");

	// conf koneksi db
	$servername = "localhost";
    $username = "root";
    $password = "Adm1nroot";
    $dbnamea = "kemahasiswaan";

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

		$nim = $_GET['nim'];
		$nama_mhs = $_GET['nama_mhs'];

		if(empty($nim) OR empty($nama_mhs)){
			$result = status(200, 'Invalid Parameter');
		}else{
			// jika GET
			$result = status(200, 'Request Valid');

		    // ambil data
		    $sql = "SELECT * FROM mahasiswa WHERE nim LIKE '%$nim%' AND nama_mhs LIKE '%$nama_mhs%'";
		    $hasilquery = $conn->query($sql);

		    // fecth all data
		    $result['results'] = $hasilquery->fetch_all(MYSQLI_ASSOC);
		}

	}else{
		// jika bukan GET
		$result = status(400, 'Request Invalid');
	}

	// parse ke format json
	echo json_encode($result);

?>