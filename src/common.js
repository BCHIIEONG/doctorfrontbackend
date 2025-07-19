//向sessionStorage中存储一个JSON对象
export function setSessionStorage(keyStr, value) {
	sessionStorage.setItem(keyStr, JSON.stringify(value));
}

//从sessionStorage中获取一个JSON对象（取不到时返回null）
export function getSessionStorage(keyStr) {
	var str = sessionStorage.getItem(keyStr);
	if (str == '' || str == null || str == 'null' || str == undefined) {
		return null;
	} else {
		return JSON.parse(str);
	}
}

//从sessionStorage中移除一个JSON对象
export function removeSessionStorage(keyStr) {
	sessionStorage.removeItem(keyStr);
}
