var xmlHttp = false;
function makeRequest(KanSea_ID,url) {
	xmlHttp = false;
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
		if (xmlHttp.overrideMimeType) {
			xmlHttp.overrideMimeType('text/html');
		}
	} else if (window.ActiveXObject) {
		try {
			xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {}
		}
	}

	if (!xmlHttp) {
		alert('您的浏览器不支持ajax');
		return false; 
	}
				KanSea_div_ID=KanSea_ID
	xmlHttp.onreadystatechange =function() {
		if (xmlHttp.readyState == 4) {
			if (xmlHttp.status == 200) {
				document.getElementById(KanSea_div_ID).innerHTML = xmlHttp.responseText;
			} else {
				document.getElementById(KanSea_div_ID).innerHTML = "未查到相关信息,或网速过慢!";
			}
		}

	}
	xmlHttp.open('GET', url, true);
	xmlHttp.send(null);
}
