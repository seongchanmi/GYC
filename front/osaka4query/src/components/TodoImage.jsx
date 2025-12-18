import { Avatar } from "@mui/material";

function TodoImage({ src, alt }) {

    const handleError = (evt) => {
        // evt.currenTarget.src = "이미지 경로"
        // evt.currenTarget: 클릭한 요소의 실제 이벤트 리스너가 걸려있는 대상
        evt.currentTarget.style.src = 'http://placehold.co/200/orange/fff?text=img';
    }

    return (
       <Avatar 
        component="span"
        src={src}
        alt={alt}
        slotProps={{
            img: {onError: handleError}
        }}
        sx={{
        width: 50,
        height: 50,
        objectFit: 'cover',
        mr: 3
       }}
        variant='rounded'
       />
    );
}

export default TodoImage;