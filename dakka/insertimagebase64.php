<?php
	// header harus json
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

	// kondisi metode
	if($smethod == 'POST'){
		// tangkap input
		$nim = $_POST['nim'];
		$nama_mhs = $_POST['nama_mhs'];
		$alamat = $_POST['alamat'];
		$image = $_POST['fileUpload'];

		// list($type, $image) = explode(';', $image);
		// list(, $image)      = explode(',', $image);

		// echo $image;

		$image = base64_decode($image);

		file_put_contents('images/'.$nim.'.jpg', $image);
		$imagename = $nim.'.jpg';

		// insert data
		$sql = "INSERT INTO mahasiswa (
					nim, 
					nama_mhs, 
					alamat, 
					foto) 
				VALUES (
					'$nim', 
					'$nama_mhs', 
					'$alamat', 
					'$imagename')";
		$conn->query($sql);

		$result['status']['code'] = 200;
		$result['status']['description'] = "1 data inserted";
		$result['result'] = array(
			"nim"=>$nim,
			"nama_mhs"=>$nama_mhs,
			"alamat"=>$alamat,
            "foto"=>$imagename
		);

	}else{
		$result['status']['code'] = 400;
	}

	// parse ke format json
	echo json_encode($result);
?>