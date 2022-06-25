
function loadMainPage(){
	loadTable();
	loadCurrentUser();
}

function loadCurrentUser(){
	var urlCurrentUser = 'http://' + document.URL.split('/')[2]+'/media/userName';
	var  currentUserName;
	
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		 if (this.readyState == 4 && this.status == 200) {
		      currentUserName = this.responseText;
		    }
		
	}
	
	  xhttp.open("GET", urlCurrentUser, false);
	  xhttp.send();
	  
	 var elem =  document.getElementById('currentUser');
	 var newHtmlText = elem.getInnerHTML()+' '+currentUserName;
	 elem.innerText = newHtmlText;

}


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
	 var newIndex = index+1;
	 
	 var row = table.insertRow(newIndex);
	 var colunm1 = row.insertCell(0);
	 var colunm2 = row.insertCell(1);
	 var colunm3 = row.insertCell(2);
	 
	 colunm1.innerHTML = item.id;
	 colunm2.innerHTML = item.musicName;	 
	 // player colun
	 var player = ' <audio onplaying="verifyPlaying('+newIndex+')"  controls preload="none" > <source src='+urlMusicInfo+item.id+' type="audio/mp3" /> your browser does not suport</audio>';
	 colunm3.innerHTML = player;

}

function verifyPlaying(index){
	
	index = index -1;
	var musics = document.getElementsByTagName('audio');
	
	for(indexMusic = 0 ; indexMusic < musics.length; indexMusic++  ){
		
		if(indexMusic != index ){
			
			if(!musics[indexMusic].paused){
			  musics[indexMusic].pause();
			}

		}
				
	}
	
} 


