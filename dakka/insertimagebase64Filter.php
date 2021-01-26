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

		list($type, $image) = explode(';', $image);
		list(, $image)      = explode(',', $image);
		$image = base64_decode($image);

		if (preg_match('/^data:image\/(\w+);base64,/', $image, $type)) {
		    $image = substr($image, strpos($image, ',') + 1);
		    $type = strtolower($type[1]); // jpg, png, gif

		    if (!in_array($type, [ 'jpg', 'jpeg', 'gif', 'png' ])) {
		        throw new \Exception('invalid image type');
		    }

		    $image = base64_decode($image);

		    if ($image === false) {
		        throw new \Exception('base64_decode failed');
		    }
		} else {
		    throw new \Exception('did not match data URI with image data');
		}

		file_put_contents("img.{$type}", $image);

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
					'$nim')";
		$conn->query($sql);

		$result['status']['code'] = 200;
		$result['status']['description'] = "1 data inserted";
		$result['result'] = array(
			"nim"=>$nim,
			"nama_mhs"=>$nama_mhs,
			"alamat"=>$alamat,
            "foto"=>$image
		);

	}else{
		$result['status']['code'] = 400;
	}

	// parse ke format json
	echo json_encode($result);
?>