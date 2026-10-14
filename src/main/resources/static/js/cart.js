let cartIds = new Set();   // 담긴 시설의 serviceId 모음
let loggedIn = false;

function initAuth() {
    return fetch('/api/me').then(r => r.json()).then(me => {
        loggedIn = me.loggedIn;
        const show = (id, on) => {
            const e = document.getElementById(id);
            if (e) e.classList.toggle('d-none', !on);
        };
        show('loginLink', !loggedIn);
        show('logoutForm', loggedIn);
        show('cartLink', loggedIn);
        return loggedIn ? loadCart() : null;
    });
}
function updateCartCount(n) {
    const badge = document.getElementById('cartCount');
    if (badge) badge.textContent = n;
}

function loadCart() {
    return fetch('/api/cart').then(r => r.json()).then(list => {
        cartIds = new Set(list.map(c => c.serviceId));
        updateCartCount(list.length);
    });
}

function makeCartButton(item) {
    if (!loggedIn) return document.createDocumentFragment();   // 이 줄 추가
    const btn = document.createElement('button');
    btn.className = 'btn btn-sm btn-outline-success';
    btn.textContent = cartIds.has(item.serviceId) ? '담김 ✓' : '담기';

    btn.onclick = () => {
        const adding = !cartIds.has(item.serviceId);
        const req = adding
            ? fetch('/api/cart', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({
                    serviceId: item.serviceId,
                    serviceName: item.serviceName,
                    placeName: item.placeName,
                    subCategory: item.subCategory,
                    serviceStatus: item.serviceStatus,
                    serviceUrl: item.serviceUrl
                })
            })
            : fetch('/api/cart/' + encodeURIComponent(item.serviceId), { method: 'DELETE' });

        req.then(r => r.json()).then(list => {
            cartIds = new Set(list.map(c => c.serviceId));
            btn.textContent = adding ? '담김 ✓' : '담기';
            updateCartCount(list.length);
        });
    };
    return btn;
}