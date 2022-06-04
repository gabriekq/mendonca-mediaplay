

function loadTable(){
	
	var urlMusicInfo ='http://' + document.URL.split('/')[2]+'/media/musicInfo';
	
	var xhttp = new XMLHttpRequest();
	 xhttp.onreadystatechange = function() {
		    if (this.readyState == 4 && this.status == 200) {
		     musicArray	 = JSON.parse(this.responseText)
		     musicArray.forEach(addMusicTable);
		    }
		  };
	         // open the request to get the data
		  xhttp.open("GET", urlMusicInfo, false);
		  xhttp.send();

}

function addMusicTable(item,index){
	
	var urlMusicInfo ='http://' + document.URL.split('/')[2]+'/media/';
	 var table = document.getElementById('music-table');
	 var row = table.insertRow(index+1);
	 var colunm1 = row.insertCell(0);
	 var colunm2 = row.insertCell(1);
	 var colunm3 = row.insertCell(2);
	 
	 colunm1.innerHTML = item.id;
	 colunm2.innerHTML = item.musicName;	 
	 // player colun
	 var player = ' <audio autoplay="autoplay" controls="controls" preload="none" > <source src='+urlMusicInfo+item.id+' type="audio/mp3" /> your browser does not suport</audio>';
	 colunm3.innerHTML = player;

}

