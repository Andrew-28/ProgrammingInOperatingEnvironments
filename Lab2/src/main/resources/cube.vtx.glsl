#version 420 compatibility

#pragma optimize(on)

#ifdef GL_ES
precision mediump float;
#else
precision highp float;
#endif

invariant gl_Position;

uniform mat4 mvp;
uniform mat4 mv;
uniform mat4 nm;

layout(location = 0) in vec3 vertex_coord;
layout(location = 1) in vec3 vertex_normal;

out vec4 eye_norm;
out vec4 eye_pos;

void main(void) {
	vec4 vcoord = vec4( vertex_coord, 1.0 );
	eye_norm = normalize( nm * vec4(vertex_normal,0.0) );
	eye_pos = mv * vcoord;
	gl_Position = mvp * vcoord;
}